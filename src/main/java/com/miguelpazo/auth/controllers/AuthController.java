package com.miguelpazo.auth.controllers;

import com.miguelpazo.auth.dto.GeneralResponse;
import com.miguelpazo.auth.dto.ReqUserAuth;
import com.miguelpazo.auth.services.interfaces.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserAuthService iAuthService;

    /**
     * TODO: Comment endpoint
     *
     * @param reqUserAuth
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> infoCertificate(@RequestBody ReqUserAuth reqUserAuth) {
        String jwtToken = iAuthService.login(reqUserAuth);

        if (jwtToken != null) {
            GeneralResponse generalResponse = new GeneralResponse(true);
            generalResponse.setData(jwtToken);

            return new ResponseEntity<>(generalResponse, HttpStatus.OK);
        }

        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }
}
