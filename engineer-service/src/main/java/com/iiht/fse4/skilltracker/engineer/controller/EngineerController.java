package com.iiht.fse4.skilltracker.engineer.controller;

import com.iiht.fse4.skilltracker.common.aspect.TrackElapsedTime;
import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.NonTechnicalSkillType;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.common.model.TechnicalSkillType;
import com.iiht.fse4.skilltracker.common.util.CriteriaTypeConverter;
import com.iiht.fse4.skilltracker.engineer.exception.EngineerServiceException;
import com.iiht.fse4.skilltracker.engineer.model.*;
import com.iiht.fse4.skilltracker.engineer.service.EngineerService;
import com.iiht.fse4.skilltracker.engineer.util.Constants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = Constants.ENGINEER_API)
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    @TrackElapsedTime
    @RequestMapping(value = "/add-profile", method = RequestMethod.OPTIONS)
    ResponseEntity<?> showOptionsOfAddProfileRequest() {
        return ResponseEntity.ok().allow(HttpMethod.POST, HttpMethod.OPTIONS).build();
    }

    @TrackElapsedTime
    @PostMapping(value = "/add-profile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddProfileResponse> handleAddProfileRequest(@Valid @RequestBody AddProfileRequest request) {
        log.info("{} method Start", Constants.HANDLE_ADD_PROFILE_REQUEST);
        AddProfileResponse response = engineerService.addProfile(request);
        log.info("{} method End", Constants.HANDLE_ADD_PROFILE_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @TrackElapsedTime
    @RequestMapping(value = "/update-profile/{profileId}", method = RequestMethod.OPTIONS)
    ResponseEntity<?> showOptionsOfUpdateProfileRequest() {
        return ResponseEntity.ok().allow(HttpMethod.PUT, HttpMethod.OPTIONS).build();
    }

    @TrackElapsedTime
    @RequestMapping(value = "/update-profile/{profileId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateProfileResponse> handleUpdateProfileRequest(final @PathVariable("profileId") @Min(1) long profileId,
                                                                            final @Valid @RequestBody UpdateProfileRequest request) {
        log.info("{} method Start", Constants.HANDLE_UPDATE_PROFILE_REQUEST);
        UpdateProfileResponse response = engineerService.updateProfile(profileId, request);
        log.info("{} method End", Constants.HANDLE_UPDATE_PROFILE_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @TrackElapsedTime
    @RequestMapping(value = "/{criteria}/{criteriaValue}", method = RequestMethod.OPTIONS)
    ResponseEntity<?> showOptionsOfSearchProfileRequest() {
        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.OPTIONS).build();
    }

    @TrackElapsedTime
    @RequestMapping(value = "/{criteria}/{criteriaValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchProfileResponse> handleSearchProfileRequest(final @PathVariable("criteria") CriteriaType criteria,
                                                                            final @PathVariable("criteriaValue") String criteriaValue) {
        log.info("{} method Start", Constants.HANDLE_SEARCH_PROFILE_REQUEST);
        if (CriteriaType.SKILL.equals(criteria) && TechnicalSkillType.fromValue(criteriaValue) == null && NonTechnicalSkillType.fromValue(criteriaValue) == null) {
            throw new EngineerServiceException(HttpStatus.BAD_REQUEST, Constants.INVALID_SKILL_NAME_MSG);
        }
        SearchProfileResponse response = engineerService.searchProfile(criteria, criteriaValue);
        log.info("{} method End", Constants.HANDLE_SEARCH_PROFILE_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(CriteriaType.class, new CriteriaTypeConverter());
    }
}
