package com.iiht.fse4.skilltracker.api.gateway.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class KeyResolver {
    private Map<String, String> kidPublicKeyMap = new HashMap<>();

    public String getKeyFromServer(String keyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String url = null;//appProps.getKeyUrl() + "?v=" + keyId;
        RestTemplate keyUriRestTemplate = new RestTemplate();
        return keyUriRestTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
    }

    private PublicKey getPublicKey(String x509Certificate) {
        try {
            CertificateFactory f = CertificateFactory.getInstance("X.509");
            InputStream certStream = new ByteArrayInputStream(x509Certificate.getBytes(StandardCharsets.UTF_8));
            X509Certificate certificate = (X509Certificate) f.generateCertificate(certStream);
            return certificate.getPublicKey();
        } catch (CertificateException e) {
            log.warn("Could not create public key from certificate {}", e.getMessage());
            return null;
        }
    }

    public PublicKey getX509PublicKey(String kid) {
        String publicKey;
        if (!kidPublicKeyMap.containsKey(kid)) {
            log.info("SUCCESSFULLY got public key for first time from kid");
            publicKey = getKeyFromServer(kid);
            kidPublicKeyMap.put(kid, publicKey);
        } else {
            log.info("RETRIEVED public key from cache");
            publicKey = kidPublicKeyMap.get(kid);
        }
        return getPublicKey(publicKey);
    }
}
