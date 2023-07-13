package com.iiht.fse4.skilltracker.engineer.util;

public interface Constants {

    String ENGINEER_API = "/skill-tracker/api/v1/engineer";

    String ENGINEER_SERVICE_EXP = "EngineerServiceException";

    String HANDLE_ENGINEER_SERVICE_EXCEPTION = "handleEngineerServiceException";

    int ENGINEER_SERVICE_CODE = 401;

    String HANDLE_ADD_PROFILE_REQUEST = "handleAddProfileRequest";

    String HANDLE_UPDATE_PROFILE_REQUEST = "handleUpdateProfileRequest";

    String HANDLE_SEARCH_PROFILE_REQUEST = "handleSearchProfileRequest";

    String ADD_PROFILE = "addProfile";

    String UPDATE_PROFILE = "updateProfile";

    String SEARCH_PROFILE = "searchProfile";

    int PROFILE_UPDATE_DAYS_LIMIT = 10;
    String PROFILE_EXISTS_EXP_MSG = "Skill Profile for this associateId already exists";

    String PROFILE_UPDATE_EXP_MSG = "User must be allowed only after 10 days of adding skills or last change";

    String PROFILE_UPDATED_SUCCESS_MSG = "User skills updated successfully";

    String UPDATE_PROFILE_EXP_MSG = "Problem occurred while updating the skill profile";

    String UPDATE_PROFILE_EXP_LOG_MSG = "Exception occurred while updateProfile method";

    String SEARCH_PROFILE_EXP_LOG_MSG = "Exception occurred while searchProfile method";

    String SEARCH_PROFILE_EXP_MSG = "Problem while searching the skill profile";

    String INVALID_SKILL_NAME_MSG = "Invalid Skill Name, please verify accepted skills";

    String CONSUME_USER_SKILL_ENTITY = "consumeProfileSaveMessage";

    String KAFKA_UPDATE_PROFILE_EXCEPTION = "Exception occurred while consumeProfileSaveMessage method";

    String CONSUME_PROFILE_ENTITY = "consumeProfileEntity";

    String KAFLA_UPDATE_PROFILE_EXP_LOG_MSG = "Exception occurred while consumeProfileEntity method";

}
