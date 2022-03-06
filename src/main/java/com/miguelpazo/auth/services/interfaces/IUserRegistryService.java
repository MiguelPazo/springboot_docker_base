package com.miguelpazo.auth.services.interfaces;

import com.miguelpazo.auth.dto.ReqUserRegistry;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IUserRegistryService {

    Boolean save(ReqUserRegistry reqUserRegistry);
}
