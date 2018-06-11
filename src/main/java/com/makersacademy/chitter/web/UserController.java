package com.makersacademy.chitter.web;

import com.makersacademy.chitter.service.SecurityService;
import com.makersacademy.chitter.service.UserService;
import com.makersacademy.chitter.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm"))
}
