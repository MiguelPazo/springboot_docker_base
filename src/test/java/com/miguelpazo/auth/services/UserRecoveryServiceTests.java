package com.miguelpazo.auth.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class UserRecoveryServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(UserRecoveryServiceTests.class);

    @BeforeAll
    public static void prepare() {
        /**
         * TODO
         */
    }

    @Test
    public void sampleTest() {
        try {
            /**
             * TODO
             */
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
