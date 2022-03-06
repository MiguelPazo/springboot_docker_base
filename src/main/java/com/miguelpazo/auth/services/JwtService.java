package com.miguelpazo.auth.services;

import com.google.gson.Gson;
import com.miguelpazo.auth.common.Utils;
import com.miguelpazo.auth.dto.JwtPayload;
import com.miguelpazo.auth.models.User;
import com.miguelpazo.auth.services.interfaces.IJwtService;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtSignatureException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class JwtService implements IJwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    @Value("${auth.jwt.issuer}")
    private String issuer;
    @Value("${auth.jwt.ttl}")
    private Float ttl;
    @Autowired
    private Utils utils;

    @Override
    public String generate(User oUser) {
        try {
            JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer(issuer);
            jwtClaims.setExpirationTimeMinutesInTheFuture(ttl / 60);

            jwtClaims.setAudience("ALL");
            jwtClaims.setGeneratedJwtId();
            jwtClaims.setIssuedAtToNow();
            jwtClaims.setSubject("AUTHTOKEN");
            jwtClaims.setClaim("email", oUser.getEmail());

            String keyData = utils.readFileFromResources("/keys/auth.json");
            RsaJsonWebKey jsonWebKey = (RsaJsonWebKey) JsonWebKey.Factory.newJwk(keyData);

            JsonWebSignature jws = new JsonWebSignature();
            jws.setPayload(jwtClaims.toJson());
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
            jws.setKey(jsonWebKey.getPrivateKey());
            jws.setDoKeyValidation(false);

            return jws.getCompactSerialization();
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }

    @Override
    public JwtPayload validate(String jwtToken) {
        try {
            String keyData = utils.readFileFromResources("/keys/auth.json");
            RsaJsonWebKey jsonWebKey = (RsaJsonWebKey) JsonWebKey.Factory.newJwk(keyData);

            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setRequireSubject()
                    .setExpectedIssuer(issuer)
                    .setExpectedAudience("ALL")
                    .setVerificationKey(jsonWebKey.getPublicKey())
                    .setRelaxVerificationKeyValidation()
                    .build();

            JwtClaims claims = jwtConsumer.processToClaims(jwtToken);

            if (NumericDate.now().getValue() < claims.getExpirationTime().getValue()) {
                Gson g = new Gson();
                return g.fromJson(claims.getRawJson(), JwtPayload.class);
            }
        } catch (InvalidJwtSignatureException ex) {
            logger.error("Invalid signature");
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }
}

