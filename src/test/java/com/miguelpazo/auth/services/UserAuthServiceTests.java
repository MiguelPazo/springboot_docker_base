package com.miguelpazo.auth.services;

import com.miguelpazo.auth.dto.ReqUserAuth;
import com.miguelpazo.auth.services.interfaces.IUserAuthService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class UserAuthServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthServiceTests.class);

    @Autowired
    private IUserAuthService userAuthService;

    private static ReqUserAuth reqUserAuth;

    @BeforeAll
    public static void prepare() {
        reqUserAuth = new ReqUserAuth();

        reqUserAuth.setEmail("miguel.ps19@gmail.com");
        reqUserAuth.setPassword("miguel");
    }

    @Test
    public void loginTest() {
        try {
            String result = userAuthService.login(reqUserAuth);

            logger.info(result);

            assertThat(result)
                    .isNotEqualTo(null);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
