package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.BaseCharacter;
import org.launchcode.dndproject.models.data.BaseCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("character")
public class CharacterController {

    @Autowired
    private BaseCharacterRepository baseCharacterRepository;

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
    public String processCreateCharacterForm(@ModelAttribute @Valid BaseCharacter newBaseCharacter,
                                             Errors errors){
        if(errors.hasErrors()){
            return "character/create";
        }

        baseCharacterRepository.save(newBaseCharacter);

        return "redirect:";
    }

    @GetMapping("view/{characterId}")
    public String displayCharacterById(){
        return "view/{characterId}";
    }
}
