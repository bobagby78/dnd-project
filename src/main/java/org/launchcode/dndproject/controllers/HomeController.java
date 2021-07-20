package org.launchcode.dndproject.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("index")
    public String index(Model model){

        model.addAttribute("title", "The Dungeon");

        return "index";
    }
}
