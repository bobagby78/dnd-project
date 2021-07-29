package org.launchcode.dndproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("character")
public class CharacterController {

    @GetMapping
    public String characterIndex(){
        return "character/index";
    }

    @GetMapping("view/{characterId}")
    public String displayCharacterById(){
        return "view/{characterId}";
    }

    @GetMapping("create")
    public String renderCreateCharacterForm(){
        return "character/create";
    }

    @PostMapping("create")
    public String processCreateCharacterForm(){
        return "redirect:";
    }

}
