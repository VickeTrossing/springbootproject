package com.vicketrossing.springbootproject.controller;

import com.vicketrossing.springbootproject.entity.User;
import com.vicketrossing.springbootproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){

        userService.save(theUser);

        return "/loginpath/login";
    }


    @RequestMapping("/showFormForReg")
    public String showFormForReg(Model theModel){

        User theUser = new User();

        theModel.addAttribute("user", theModel);

        return "loginpath/registration";

    }


}
