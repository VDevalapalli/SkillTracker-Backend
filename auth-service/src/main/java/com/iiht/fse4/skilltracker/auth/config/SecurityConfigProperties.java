package com.iiht.fse4.skilltracker.auth.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Component
@FieldDefaults(level = PRIVATE)
public class SecurityConfigProperties {
    @Value("${security.crypto.secretkey}")
    String secretKey;
    @Value("${security.crypto.salt}")
    String salt;
    @Value("${security.jwt.signing.private-key}")
    String jwtSigningPrivateKey;
    @Value("${security.jwt.signing.public-key}")
    String jwtSigningPublicKey;
}
