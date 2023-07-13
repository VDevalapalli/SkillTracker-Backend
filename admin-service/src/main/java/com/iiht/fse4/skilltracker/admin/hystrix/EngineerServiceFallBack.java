package com.iiht.fse4.skilltracker.admin.hystrix;

import com.iiht.fse4.skilltracker.admin.client.EngineerServiceClient;
import com.iiht.fse4.skilltracker.admin.util.Constants;
import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.common.util.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EngineerServiceFallBack implements EngineerServiceClient {
    @Override
    public SearchProfileResponse searchProfile(CriteriaType criteria, String criteriaValue) {
        log.info(CommonConstants.METHOD_START, Constants.DEFAULT_SEARCH_PROFILE);
        SearchProfileResponse response = new SearchProfileResponse();
        log.info(CommonConstants.METHOD_END, Constants.DEFAULT_SEARCH_PROFILE);
        return response;
    }
}
