package com.miguelpazo.auth.services;

import com.miguelpazo.auth.dto.JwtPayload;
import com.miguelpazo.auth.models.User;
import com.miguelpazo.auth.services.interfaces.IJwtService;
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
class JwtServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(JwtServiceTests.class);

    @Autowired
    private IJwtService jwtService;

    @BeforeAll
    public static void prepare() {
        /**
         * TODO
         */
    }

    @Test
    public void generateTest() {
        try {
            User oUser = new User();
            oUser.setEmail("miguel.ps19@gmail.com");

            String jwtToken = jwtService.generate(oUser);

            logger.info(jwtToken);

            assertThat(jwtToken)
                    .isNotEqualTo(null);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }

    @Test
    public void validateTest() {
        try {
            String jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJtaWd1ZWwiLCJleHAiOjE2NDY1OTUyNTksImF1ZCI6IkFMTCIsImp0aSI6IjdBdE9RUV9HY25uZEQ0cnBRaHdkNGciLCJpYXQiOjE2NDY1OTE2NTksInN1YiI6IkFVVEhUT0tFTiIsImVtYWlsIjoibWlndWVsLnBzMTlAZ21haWwuY29tIn0.Z25eSxQnK8FcY_JLAVM6FYNOOqrkkxOg9-F4MrHckXpDRcgwK4pnFloGv1ayhMGhNOy5jNCgz01GCRSAull8FCDPiNe8vvZgirhRBc1pB-o6pjEUZWDBFnRSKxjVjnH-HpRbB6VeNd5t-eMqX11oHIv4qYh-IMzqi4MpNqMe4dO8Tn90aAJPhyw7vSOcVf4GcW-gzDA8gnko_U-M9ijy46igN2wxJoAqgftBisZMjsaYLB7580SiSyvf3_JJ1dtnLLy6yg4GnTDkIIdgUz0DLuZ3tW2v-0AQrQbbqs2I70iBtWgw-4Tl4IoNrnbAReLiS8Uj1mGFgAOIXo5-zDvGRQ";
            JwtPayload result = jwtService.validate(jwtToken);

            logger.info(result.toString());

            assertThat(result)
                    .isNotEqualTo(null);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
