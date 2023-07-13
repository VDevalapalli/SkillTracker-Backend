package com.iiht.fse4.skilltracker.admin.service;

import com.iiht.fse4.skilltracker.common.model.CriteriaType;
import com.iiht.fse4.skilltracker.common.model.GetProfileResponse;
import com.iiht.fse4.skilltracker.common.model.SearchProfileResponse;
import com.iiht.fse4.skilltracker.common.model.SkillProfile;

public interface SkillProfileService {
    SkillProfile saveProfile(SkillProfile skillProfile);

    GetProfileResponse getProfileByAssociateId(String associateId);

    SearchProfileResponse searchProfileByCriteria(CriteriaType criteria, String criteriaValue);
}
