package com.miguelpazo.auth.services.interfaces;

import com.miguelpazo.auth.dto.ReqPasswordNew;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IUserRecoveryService {

    Boolean recoveryPassword(String email);

    Boolean saveNewPassword(ReqPasswordNew reqPasswordNew);
}
