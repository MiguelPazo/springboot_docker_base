package com.miguelpazo.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@RestController
@RequestMapping("")
public class IndexController {

    /**
     * TODO: Comment endpoint
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getIndex() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
