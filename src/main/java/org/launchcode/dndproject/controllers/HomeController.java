package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("title", "Welcome to the Dungeon!!!");
        model.addAttribute("subtitle", "Are you ready to play?!?!");
        return "/index";
    }

//    @GetMapping("login")
//    public String renderLoginAndRegister(Model model, ){
//        model.addAttribute("title", "Registration and Login");
//        model.addAttribute(new User());
//        return"/login";
//    }
//
//    @PostMapping("login")
//    public String processLoginAndRegister(){
//        return"/";
//    }

}
