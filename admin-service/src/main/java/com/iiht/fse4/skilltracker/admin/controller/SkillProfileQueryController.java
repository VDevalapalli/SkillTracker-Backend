package com.iiht.fse4.skilltracker.admin.controller;

import com.iiht.fse4.skilltracker.admin.exception.AdminServiceException;
import com.iiht.fse4.skilltracker.admin.service.SkillProfileService;
import com.iiht.fse4.skilltracker.admin.util.Constants;
import com.iiht.fse4.skilltracker.common.aspect.TrackElapsedTime;
import com.iiht.fse4.skilltracker.common.model.*;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import com.iiht.fse4.skilltracker.common.util.CriteriaTypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = Constants.QUERY_API)
public class SkillProfileQueryController {

    @Autowired
    SkillProfileService skillProfileService;

    @TrackElapsedTime
    @GetMapping(value = "/{criteria}/{criteriaValue}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchProfileResponse> handleSearchProfileRequest(final @PathVariable("criteria") CriteriaType criteria,
                                                                            final @PathVariable("criteriaValue") String criteriaValue, HttpServletRequest request) throws AdminServiceException {
        log.info("{} method Start", Constants.HANDLE_SEARCH_PROFILE_REQUEST);
        if (CriteriaType.SKILL.equals(criteria) && TechnicalSkillType.fromValue(criteriaValue) == null && NonTechnicalSkillType.fromValue(criteriaValue) == null) {
            throw new AdminServiceException(HttpStatus.BAD_REQUEST, Constants.INVALID_SKILL_NAME_MSG);
        }
        final String accessToken = request.getHeader(CommonConstants.AUTHORIZATION);

        SearchProfileResponse response = skillProfileService.searchProfileByCriteria(criteria, criteriaValue);
        log.info("{} method End", Constants.HANDLE_SEARCH_PROFILE_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public ResponseEntity<GetProfileResponse> handleGetProfileRequest(@PathVariable(required = false) String associateId) {
        log.info("{} method Start", Constants.HANDLE_SEARCH_PROFILE_REQUEST);
        GetProfileResponse response = skillProfileService.getProfileByAssociateId(associateId);
        log.info("{} method End", Constants.HANDLE_SEARCH_PROFILE_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(CriteriaType.class, new CriteriaTypeConverter());
    }
}
