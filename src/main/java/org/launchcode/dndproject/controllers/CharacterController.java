package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.BaseCharacter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("create")
    public String renderCreateCharacterForm(Model model){
        model.addAttribute("title", "Create Character");
        model.addAttribute(new BaseCharacter());
        model.addAttribute("");

        return "character/create";
    }

    @PostMapping("create")
    public String processCreateCharacterForm(){
        return "redirect:";
    }

    @GetMapping("view/{characterId}")
    public String displayCharacterById(){
        return "view/{characterId}";
    }
}
