package com.miguelpazo.auth.services;

import com.miguelpazo.auth.dto.ReqPasswordNew;
import com.miguelpazo.auth.respositories.IUserRepository;
import com.miguelpazo.auth.services.interfaces.IUserRecoveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class UserRecoveryService implements IUserRecoveryService {

    private static final Logger logger = LoggerFactory.getLogger(UserRecoveryService.class);

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Boolean recoveryPassword(String email) {
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

    @Override
    public Boolean saveNewPassword(ReqPasswordNew reqPasswordNew) {
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

