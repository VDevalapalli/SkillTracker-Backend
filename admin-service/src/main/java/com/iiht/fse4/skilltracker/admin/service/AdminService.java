package com.iiht.fse4.skilltracker.admin.service;

import com.iiht.fse4.skilltracker.admin.exception.AdminServiceException;
import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;

public interface AdminService {
    SearchProfileResponse searchProfile(final String accessToken, final CriteriaType criteria, final String criteriaValue) throws AdminServiceException;
}
