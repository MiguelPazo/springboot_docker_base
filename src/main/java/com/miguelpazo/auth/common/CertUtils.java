package com.miguelpazo.auth.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class CertUtils {

    private static final Logger logger = LoggerFactory.getLogger(CertUtils.class);

    public String convertToRsaFormat(Key rsaKey, Boolean isPublic) {
        String pem = new String(Base64.getEncoder().encode(rsaKey.getEncoded()));
        String beginCert = isPublic ? "-----BEGIN PUBLIC KEY-----" : "-----BEGIN PRIVATE KEY-----";
        String endCert = isPublic ? "-----END PUBLIC KEY-----" : "-----END PRIVATE KEY-----";
        String finalPem = beginCert;

        int begin = 0;
        finalPem += "\n" + pem.substring(begin, 64);
        begin += 64;

        while (begin < pem.length()) {
            int end = Math.min(begin + 64, pem.length());
            finalPem += "\n" + pem.substring(begin, end);
            begin += 64;
        }

        finalPem += "\n" + endCert;

        return finalPem;
    }
}
