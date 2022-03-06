package com.miguelpazo.auth.services.interfaces;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IMailingService {

    Boolean sendPasswordRecovery(String email);
}
