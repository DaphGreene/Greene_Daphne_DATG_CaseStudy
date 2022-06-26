package com.datg.Greene_Daphne_DATG_CaseStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/music")
    public String music() {
        return "music";
    }

    @GetMapping("/tour")
    public String tour() {
        return "tour";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}

