package com.iiht.fse4.skilltracker.engineer.service;

import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.engineer.exception.EngineerServiceException;
import com.iiht.fse4.skilltracker.engineer.model.*;

public interface EngineerService {
    public AddProfileResponse addProfile(final AddProfileRequest request) throws EngineerServiceException;

    public UpdateProfileResponse updateProfile(final long profileId, final UpdateProfileRequest request) throws EngineerServiceException;

    public SearchProfileResponse searchProfile(final CriteriaType criteria, final String criteriaValue) throws EngineerServiceException;

}
