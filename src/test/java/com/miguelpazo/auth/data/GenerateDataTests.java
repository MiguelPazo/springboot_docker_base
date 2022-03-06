package com.miguelpazo.auth.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miguelpazo.auth.common.CertUtils;
import com.miguelpazo.auth.common.Utils;
import com.miguelpazo.auth.models.User;
import com.miguelpazo.auth.respositories.IUserRepository;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class GenerateDataTests {

    private static final Logger logger = LoggerFactory.getLogger(GenerateDataTests.class);

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private Utils utils;
    @Autowired
    private CertUtils certUtils;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void generateTest() {
        try {
            mongoTemplate.remove(new Query(), "users");

            User oUser = new User();

            oUser.setEmail("miguel.ps19@gmail.com");
            oUser.setPassword(utils.hash("miguel"));
            oUser.setFirstname("Miguel");
            oUser.setLastnames("Pazo Sánchez");
            oUser.setCreatedAt(new Date());

            userRepository.save(oUser);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }

    @Test
    public void generateKeysTest() {
        try {
            RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
            rsaJsonWebKey.setKeyId("k1");

            String jwk = new JsonWebKeySet(rsaJsonWebKey).toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
            String jwkPublic = new JsonWebKeySet(rsaJsonWebKey).toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);

            JsonObject joJwk = JsonParser.parseString(jwk).getAsJsonObject();
            JsonObject joJwkPublic = JsonParser.parseString(jwkPublic).getAsJsonObject();

            jwk = joJwk.get("keys").getAsJsonArray().get(0).toString();
            jwkPublic = joJwkPublic.get("keys").getAsJsonArray().get(0).toString();

            String pemPrivate = certUtils.convertToRsaFormat(rsaJsonWebKey.getRsaPrivateKey(), false);
            String pemPublic = certUtils.convertToRsaFormat(rsaJsonWebKey.getRsaPublicKey(), true);

            String path = System.getProperty("user.dir") + "/src/main/resources/keys/";

            utils.saveToFile(jwk, path + "auth.json");
            utils.saveToFile(jwkPublic, path + "auth_public.json");
            utils.saveToFile(pemPrivate, path + "auth_private.pem");
            utils.saveToFile(pemPublic, path + "auth_public.pem");
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
