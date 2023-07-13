package com.iiht.fse4.skilltracker.auth.util;

public interface AuthConstants {
    String AUTH_API = "/skill-tracker/auth";

    String AUTH_MSG_SUCCESS = "Authentication Success";
    String AUTH_MSG_FAILURE = "Authentication Failure";
    String FACTORY_ALGO_KEY = "PBKDF2WithHmacSHA256";
    String SECRET_KEY_ALGO = "AES";
    String CIPHER = "AES/CBC/PKCS5Padding";
    String AUTHORIZATION = "Authorization";
    String AUTH_TYPE = "Bearer";
    String ROLE_FSE = "FSE";
}
