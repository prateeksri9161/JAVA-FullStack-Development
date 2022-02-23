package com.example.modules.home.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MyController {

    @RequestMapping("/")
    public String showHome() {
        System.out.println("ShowHome");
        return "home";
    }


    @RequestMapping("home")
    public String showHome2() {
        System.out.println("home2");
        return "home";
    }
}
