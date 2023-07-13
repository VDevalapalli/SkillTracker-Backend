//package com.iiht.fse4.skilltracker.auth.util;
//
//import com.iiht.fse4.skilltracker.auth.config.SecurityConfigProperties;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//
//import javax.crypto.spec.IvParameterSpec;
//
//import static org.mockito.Mockito.*;
//
//class EncryptionUtilTest {
//    @Mock
//    SecurityConfigProperties securityConfigProperties;
//    //Field iv of type byte[] - was not mocked since Mockito doesn't mock arrays
//    @Mock
//    IvParameterSpec ivPSpec;
//    @Mock
//    Logger log;
//    @InjectMocks
//    EncryptionUtil encryptionUtil;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testEncrypt() {
//        when(securityConfigProperties.getSecretKey()).thenReturn("getSecretKeyResponse");
//        when(securityConfigProperties.getSalt()).thenReturn("getSaltResponse");
//
//        String result = encryptionUtil.encrypt("value");
//        Assertions.assertEquals("replaceMeWithExpectedResult", result);
//    }
//
//    @Test
//    void testDecrypt() {
//        when(securityConfigProperties.getSecretKey()).thenReturn("$K!11TR@K@R_KEY");
//        when(securityConfigProperties.getSalt()).thenReturn("$K!11TR@K@R");
//        String result = encryptionUtil.decrypt("rLbi1lY8iGwulBPJslYm7w==");
//        System.out.println(result);
//        //Assertions.assertEquals("replaceMeWithExpectedResult", result);
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme