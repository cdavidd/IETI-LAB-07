package edu.escuelaing.ieti.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.ieti.app.services.UserService;

@RestController
@RequestMapping(value = "/Users")
public class UserController {

    @Autowired
    UserService userService;

}