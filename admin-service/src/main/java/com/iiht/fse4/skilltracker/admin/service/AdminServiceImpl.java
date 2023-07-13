package com.iiht.fse4.skilltracker.admin.service;

import com.iiht.fse4.skilltracker.admin.client.EngineerServiceClient;
import com.iiht.fse4.skilltracker.admin.exception.AdminServiceException;
import com.iiht.fse4.skilltracker.admin.util.Constants;
import com.iiht.fse4.skilltracker.common.aspect.TrackElapsedTime;
import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private EngineerServiceClient engineerServiceClient;

    @Override
    @TrackElapsedTime
    public SearchProfileResponse searchProfile(String accessToken, CriteriaType criteria, String criteriaValue) throws AdminServiceException {
        log.info("{} method Start", Constants.SEARCH_PROFILE);
        SearchProfileResponse response = engineerServiceClient.searchProfile(criteria, criteriaValue);
        log.info(CommonConstants.METHOD_END, Constants.SEARCH_PROFILE);
        return response;
    }
}
