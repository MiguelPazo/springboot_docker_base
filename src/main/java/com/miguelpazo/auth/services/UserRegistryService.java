package com.miguelpazo.auth.services;

import com.miguelpazo.auth.dto.ReqUserRegistry;
import com.miguelpazo.auth.respositories.IUserRepository;
import com.miguelpazo.auth.services.interfaces.IUserRegistryService;
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
public class UserRegistryService implements IUserRegistryService {

    private static final Logger logger = LoggerFactory.getLogger(UserRegistryService.class);

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Boolean save(ReqUserRegistry reqUserRegistry) {
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

