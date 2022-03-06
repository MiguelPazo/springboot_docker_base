package com.miguelpazo.auth.respositories;

import com.miguelpazo.auth.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IUserRepository extends MongoRepository<User, String> {

    @Query("{'email': ?0, 'enabled': true, 'deleted': false}")
    User findByEmail(String email);
}
