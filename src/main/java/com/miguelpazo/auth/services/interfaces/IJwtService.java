package com.miguelpazo.auth.services.interfaces;

import com.miguelpazo.auth.dto.JwtPayload;
import com.miguelpazo.auth.models.User;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IJwtService {

    String generate(User oUser);

    JwtPayload validate(String jwtToken);
}
