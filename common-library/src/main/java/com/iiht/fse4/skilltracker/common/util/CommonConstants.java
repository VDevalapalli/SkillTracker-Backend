package com.iiht.fse4.skilltracker.common.util;

import java.util.*;

public interface CommonConstants {

    String AUTHORIZATION = "Authorization";
    String INVALID_CRITERIA_TYPE_MSG = "Invalid Criteria, accepted Criteria is: (NAME, ASSOCIATE-ID, SKILL)";

    String DO_FILTER_INTERNAL = "doFilterInternal";
    String HANDLE_ERROR = "handleError";
    String GERNERIC_EXCEPTION = "gernericException";
    String HANDLE_EXCEPTION_INTERNAL = "handleExceptionInternal";

    String METHOD_START = ">>>>>>>>>>>>>>>>>> {} >>>>>>>>>>>>>>>>>>";
    String METHOD_END = "<<<<<<<<<<<<<<<<<< {} <<<<<<<<<<<<<<<<<<";
    String ERROR_MSG_START = "Exception occured in ";
    String ERROR_MSG_END = ", Exception is : ";
    String TOKEN_REQUIRED_MSG = "JWT Token is required";
    String TOKEN_PREFIX_MSG = "JWT Token does not begin with Bearer String";
    String INVALID_TOKEN_MSG = "Unable to get JWT Token";
    String TOKEN_EXPIRED_MSG = "JWT Token has expired";
    String INVALID_SKILL_TYPE_MSG = "Invalid Skill Type";

    String INVALID_TOKEN_EXP = "InvalidTokenException";
    public static final int INVALID_TOKEN_CODE = 101;
    String INVALID_INPUT_EXP = "InvalidInputException";
    public static final int INVALID_INPUT_CODE = 201;
    String INVALID_REQUEST_EXP = "InvalidRequestException";
    public static final int INVALID_REQUEST_CODE = 202;
    String INVALID_ENDPOINT_EXP = "InvalidEndPointException";
    public static final int INVALID_ENDPOINT_CODE = 301;

    String CORRELATION_ID = "correlationId";
    String CI = "CI";
    String STRING_WHITE_SPACE = " ";
    String REQ_NOT_READABLE_DELIM = ";";
    public static Map<Integer, String> ENDPOINT_ERROR_MSGS= new HashMap<Integer, String>(){{

        put(404, "The requested endpoint is not found");
        put(415,  "The requested payload isin unsupported format");
    }};
}
