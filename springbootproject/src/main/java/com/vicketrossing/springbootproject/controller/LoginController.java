package com.vicketrossing.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String user(){
        return "store/frontpage";
    }

    @GetMapping("/admin")
    public String admin(){
        return null;
    }

    @GetMapping("/login")
    public String login(){
        return "/loginpath/login";
    }

    @GetMapping("/showFormForReg")
    public String showFormForReg(){
        return "loginpath/registration";
    }

}
