package com.makersacademy.chitter.web;

import com.makersacademy.chitter.model.User;
import com.makersacademy.chitter.service.SecurityService;
import com.makersacademy.chitter.service.UserService;
import com.makersacademy.chitter.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping(value="/users")
    public String registration(@RequestBody User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "login";
        }
        User dummyUser = new User(user.getUsername(), user.getPassword(), user.getPasswordConfirm());

        userService.save(user);

        securityService.autoLogin(user.getUsername(), dummyUser.getPasswordConfirm());

        return "redirect:/peeps";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(Model model, String error, String logout){
        System.out.println("Model = " + model);
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }

        return new ModelAndView("login", "loginModel", model);
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logout(){

        return "login";
    }

    @RequestMapping(value = "/peeps")
    public String home() { return "home"; }
}
