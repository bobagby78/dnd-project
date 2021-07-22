package org.launchcode.dndproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String intro(Model model){
        model.addAttribute("title", "Welcome to the Dungeon!!!");
        model.addAttribute("subtitle", "Are you ready to play?!?!");
        return "index";
    }

}
