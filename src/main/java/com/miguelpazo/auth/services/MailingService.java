package com.miguelpazo.auth.services;

import com.miguelpazo.auth.services.interfaces.IMailingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class MailingService implements IMailingService {

    private static final Logger logger = LoggerFactory.getLogger(MailingService.class);

    @Override
    public Boolean sendPasswordRecovery(String email) {
        try {
            /**
             * TODO
             */
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return false;
    }
}

