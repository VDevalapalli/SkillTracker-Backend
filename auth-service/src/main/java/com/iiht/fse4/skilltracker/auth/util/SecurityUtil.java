package com.iiht.fse4.skilltracker.auth.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

@Slf4j
public class SecurityUtil {
    public static Pair<String, String> decodeBase64(HttpHeaders headers) {
        Pair<String, String> userNamePassword = null;
        if (headers.containsKey(AuthConstants.AUTHORIZATION)) {
            String authorization = Objects.requireNonNull(headers.get(AuthConstants.AUTHORIZATION)).get(0);
            if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
                // Authorization: Basic base64credentials
                String base64Credentials = authorization.substring("Basic".length()).trim();
                byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
                String credentials = new String(credDecoded, StandardCharsets.UTF_8);
                // credentials = username:password
                final String[] values = credentials.split(":", 2);
                userNamePassword = Pair.of(values[0], values[1]);
            }
        }
        return userNamePassword;
    }

    public static String extractToken(HttpHeaders headers) {
        String token = "";
        if (headers.containsKey(AuthConstants.AUTHORIZATION)) {
            String authorization = Objects.requireNonNull(headers.get(AuthConstants.AUTHORIZATION)).get(0);
            if (authorization != null && authorization.toLowerCase().startsWith("bearer")) {
                token = authorization.substring("Bearer".length()).trim();
            }
        }
        return token;
    }
}
