package com.miguelpazo.auth.services.interfaces;

import com.miguelpazo.auth.dto.ReqUserAuth;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IUserAuthService {

    String login(ReqUserAuth reqUserAuth);
}
