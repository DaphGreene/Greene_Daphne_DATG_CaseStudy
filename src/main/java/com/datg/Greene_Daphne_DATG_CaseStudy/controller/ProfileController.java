package com.datg.Greene_Daphne_DATG_CaseStudy.controller;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProfileController {

    @Autowired
    private UserService userService;
        
    @RequestMapping(value="/profile")
    public String profile(Model model, Principal principal) {

        String username = principal.getUsername();

        model.addAttribute(attributeName, attributeValue)

        return "profile";
    }

}
