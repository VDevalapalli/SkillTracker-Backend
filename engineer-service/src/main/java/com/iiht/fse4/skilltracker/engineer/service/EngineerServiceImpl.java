package com.iiht.fse4.skilltracker.engineer.service;

import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.ProfileEvent;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.common.model.SkillProfile;
import com.iiht.fse4.skilltracker.engineer.entity.ProfileEntity;
import com.iiht.fse4.skilltracker.engineer.exception.EngineerServiceException;
import com.iiht.fse4.skilltracker.engineer.producer.SkillProfileProducer;
import com.iiht.fse4.skilltracker.engineer.repository.EngineerRepository;
import com.iiht.fse4.skilltracker.engineer.util.Constants;
import com.iiht.fse4.skilltracker.engineer.util.EngineerServiceUtils;
import com.iiht.fse4.skilltracker.engineer.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    public EngineerRepository engineerRepository;

    @Autowired
    private SkillProfileProducer skillProfileProducer;

    @Override
    @Transactional
    public AddProfileResponse addProfile(AddProfileRequest request) throws EngineerServiceException {
        log.info("{} method Start", Constants.ADD_PROFILE);

        AddProfileResponse response = null;
        try {
            if(engineerRepository.existsByAssociateId(request.getAssociateId())) {
                throw new EngineerServiceException(HttpStatus.BAD_REQUEST, Constants.PROFILE_EXISTS_EXP_MSG);
            }
            ProfileEntity profileEntity = engineerRepository.save(EngineerServiceUtils.convertToEntity(request));
            SkillProfile skillProfile = EngineerServiceUtils.convertToModel(profileEntity);

            ProfileEvent profileEvent = new ProfileEvent();
            profileEvent.setStatus("SUCCESS");
            profileEvent.setMessage("Skill Profile Created Successfully");
            profileEvent.setSkillProfile(skillProfile);
            skillProfileProducer.sendUserSkillProfile(profileEvent);

            response = new AddProfileResponse(EngineerServiceUtils.convertToModel(profileEntity));
        }catch (EngineerServiceException ex) {
            log.error("Exception Occurred in addProfile", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception Occurred in addProfile", ex);
            throw new EngineerServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "Problem while adding the profile");
        } finally {
            log.info("{} method End", Constants.ADD_PROFILE);
        }
        return response;
    }

    @Override
    @Transactional
    public UpdateProfileResponse updateProfile(long profileId, UpdateProfileRequest request) throws EngineerServiceException {
        log.info("{} method Start", Constants.UPDATE_PROFILE);

        UpdateProfileResponse response = null;
        try {
            Optional<ProfileEntity> profileEntityOptionalObj = engineerRepository.findById(profileId);
            if (!profileEntityOptionalObj.isPresent()) {
                throw new EngineerServiceException(HttpStatus.BAD_REQUEST, "Invalid profileId");
            } else if (ChronoUnit.DAYS.between(profileEntityOptionalObj.get().getLastUpdatedTime(), LocalDateTime.now()) <= Constants.PROFILE_UPDATE_DAYS_LIMIT) {
                throw new EngineerServiceException(HttpStatus.BAD_REQUEST, Constants.PROFILE_UPDATE_EXP_MSG);
            }
            ProfileEntity profileEntityObj = EngineerServiceUtils.updateSkillEntity(profileEntityOptionalObj.get(), request);
            ProfileEntity profileEntity = engineerRepository.save(profileEntityObj);
            SkillProfile skillProfile = EngineerServiceUtils.convertToModel(profileEntity);

            ProfileEvent profileEvent = new ProfileEvent();
            profileEvent.setStatus("SUCCESS");
            profileEvent.setMessage("Skill Profile Updated Successfully");
            profileEvent.setSkillProfile(skillProfile);
            skillProfileProducer.sendUserSkillProfile(profileEvent);

            //kafkaTemplate.send(profileTopic, profileEntityObj);
            response = new UpdateProfileResponse();
            response.setRequest(request);
            response.setMessage(Constants.PROFILE_UPDATED_SUCCESS_MSG);
        } catch (EngineerServiceException ex) {
            log.error(Constants.UPDATE_PROFILE_EXP_LOG_MSG, ex);
            throw ex;
        } catch (Exception ex) {
            log.error(Constants.UPDATE_PROFILE_EXP_LOG_MSG, ex);
            throw new EngineerServiceException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.UPDATE_PROFILE_EXP_MSG);
        } finally {
            log.info("{} method End", Constants.UPDATE_PROFILE);
        }
        return response;
    }

    @Override
    @Transactional
    public SearchProfileResponse searchProfile(CriteriaType criteria, String criteriaValue) throws EngineerServiceException {
        log.info("{} method Start", Constants.SEARCH_PROFILE);
        SearchProfileResponse response = null;
        try {
            List<ProfileEntity> userSkillEntities = null;
            switch (criteria) {
                case NAME:
                    userSkillEntities = engineerRepository.findByProfileNameStartsWith(criteriaValue);
                    break;
                case SKILL:
                    userSkillEntities = engineerRepository.findBySkillNameAndExpertiseLevel(criteriaValue);
                    break;
                case ASSOCIATE_ID:
                default:
                    userSkillEntities = engineerRepository.findByAssociateId(criteriaValue);
                    break;
            }
            List<SkillProfile> skillProfiles = Optional.ofNullable(userSkillEntities).orElseGet(ArrayList::new).stream()
                    .map(EngineerServiceUtils::convertToModel).collect(Collectors.toList());
            response = new SearchProfileResponse(skillProfiles);
        } catch (Exception ex) {
            log.error(Constants.SEARCH_PROFILE_EXP_LOG_MSG, ex);
            throw new EngineerServiceException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SEARCH_PROFILE_EXP_MSG);
        } finally {
            log.info("{} method End", Constants.SEARCH_PROFILE);
        }
        return response;
    }
}
