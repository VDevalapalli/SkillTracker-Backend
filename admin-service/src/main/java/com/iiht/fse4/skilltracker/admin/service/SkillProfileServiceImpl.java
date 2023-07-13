package com.iiht.fse4.skilltracker.admin.service;

import com.iiht.fse4.skilltracker.admin.repository.SkillProfileRepository;
import com.iiht.fse4.skilltracker.admin.util.Constants;
import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.GetProfileResponse;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.common.model.SkillProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SkillProfileServiceImpl implements SkillProfileService {

    @Autowired
    private SkillProfileRepository skillProfileRepository;

    @Override
    public SkillProfile saveProfile(SkillProfile skillProfile) {
        log.info("{} method Start", "saveProfile");
        SkillProfile skillProfileObj = null;
        try {
            final Optional<SkillProfile> skillProfileOptional = skillProfileRepository.findById(Long.valueOf(skillProfile.getProfileId()));
            if (skillProfileOptional.isPresent()) {
                skillProfileObj = skillProfileOptional.get();
            } else {
                skillProfileObj = new SkillProfile();
                skillProfileObj.setProfileId(skillProfile.getProfileId());
                skillProfileObj.setAssociateId(skillProfile.getAssociateId());
            }
            skillProfileObj.setProfileName(skillProfile.getProfileName());
            skillProfileObj.setEmail(skillProfile.getEmail());
            skillProfileObj.setMobile(skillProfile.getMobile());
            skillProfileObj.setTechnicalSkills(skillProfile.getTechnicalSkills());
            skillProfileObj.setNonTechnicalSkills(skillProfile.getNonTechnicalSkills());
            skillProfileObj = skillProfileRepository.save(skillProfileObj);
        } catch (Exception ex) {
            log.error("Error occurred while persisting the profile data: {}", ex.getMessage(), ex);
        }
        log.info("{} method End", "saveProfile");
        return skillProfileObj;
    }

    @Override
    public GetProfileResponse getProfileByAssociateId(String associateId) {
        SkillProfile skillProfile = null;
        String message = Constants.MSG_SUCCESS;
        HttpStatus status = HttpStatus.OK;
        GetProfileResponse getProfileResponse = null;

        try {
            skillProfile = skillProfileRepository.findSkillProfileByAssociateId(associateId);

            getProfileResponse = new GetProfileResponse(skillProfile);
        } catch (Exception ex) {
            log.error("Error occurred while getting the profile for associate Id: {}", ex.getMessage(), ex);
            message = Constants.MSG_FAILURE;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return getProfileResponse;
    }

    @Override
    public SearchProfileResponse searchProfileByCriteria(CriteriaType criteria, String criteriaValue) {
        List<SkillProfile> profileList = new ArrayList<>();
        String message = Constants.MSG_SUCCESS;
        HttpStatus status = HttpStatus.OK;
        SearchProfileResponse searchProfileResponse = null;
        try {
            switch (criteria) {
                case NAME:
                    profileList = skillProfileRepository.findSkillProfilesByProfileNameStartsWith(criteriaValue);
                    break;
                case SKILL:
                    profileList = skillProfileRepository.findBySkillNameAndExpertiseLevel(criteriaValue);
                    break;
                case ASSOCIATE_ID:
                default:
                    profileList = skillProfileRepository.findSkillProfilesByAssociateId(criteriaValue);
                    break;
            }

            searchProfileResponse = new SearchProfileResponse(profileList);
        } catch (Exception ex) {
            log.error("Error occurred while getting the profile list: {}", ex.getMessage(), ex);
            message = Constants.MSG_FAILURE;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return searchProfileResponse;
    }
}
