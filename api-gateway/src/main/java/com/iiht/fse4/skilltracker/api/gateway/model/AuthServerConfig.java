package com.iiht.fse4.skilltracker.api.gateway.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthServerConfig {
    private String authority;
    private String clientId;
    private String scope;
    private String responseType;
    private boolean silentRenew;
    private boolean useRefreshToken;
    private boolean disableRefreshIdTokenAuthTimeValidation;
}
