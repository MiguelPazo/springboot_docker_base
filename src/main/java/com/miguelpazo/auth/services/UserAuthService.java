package com.miguelpazo.auth.services;

import com.miguelpazo.auth.common.Utils;
import com.miguelpazo.auth.dto.ReqUserAuth;
import com.miguelpazo.auth.models.User;
import com.miguelpazo.auth.respositories.IUserRepository;
import com.miguelpazo.auth.services.interfaces.IJwtService;
import com.miguelpazo.auth.services.interfaces.IUserAuthService;
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
public class UserAuthService implements IUserAuthService {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthService.class);

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private Utils utils;
    @Autowired
    private IJwtService jwtService;

    @Override
    public String login(ReqUserAuth reqUserAuth) {
        try {
            User oUser = userRepository.findByEmail(reqUserAuth.getEmail());

            if (oUser == null) {
                return null;
            }

            if (oUser.getPassword().equals(utils.hash(reqUserAuth.getPassword()))) {
                return jwtService.generate(oUser);
            }
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }
}

