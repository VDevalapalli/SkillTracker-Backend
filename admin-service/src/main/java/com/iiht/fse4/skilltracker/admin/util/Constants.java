package com.iiht.fse4.skilltracker.admin.util;

public interface Constants {

    String ADMIN_API = "/skill-tracker/api/v1/admin";

    String QUERY_API = "/query";
    String SEARCH_PROFILE = "searchProfile";

    String DEFAULT_SEARCH_PROFILE = "defaultSearchProfile";

    String HANDLE_SEARCH_PROFILE_REQUEST = "handleSearchProfileRequest";

    String INVALID_SKILL_NAME_MSG = "Invalid Skill Name";

    String CONSUME_USER_SKILL_ENTITY = "consumeProfileSaveMessage";

    String KAFKA_UPDATE_PROFILE_EXCEPTION = "Exception occurred while consumeProfile method";

    String HANDLE_ADMIN_SERVICE_EXCEPTION = "handleAdminServiceException";

    String ADMIN_SERVICE_EXP = "AdminServiceException";

    int ADMIN_SERVICE_CODE = 401;

    String MSG_SUCCESS = "SUCCESS";
    String MSG_FAILURE = "FAILURE";

}
