package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.CharacterIdentity;
import org.launchcode.dndproject.models.data.CharacterIdentityRepository;
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
    private CharacterIdentityRepository characterIdentityRepository;

    @GetMapping
    public String characterIndex(){
        return "character/index";
    }

    @GetMapping("create")
    public String renderCreateCharacterForm(Model model){
        model.addAttribute("title", "Create Character");
        model.addAttribute(new CharacterIdentity());
        model.addAttribute("");

        return "character/create";
    }

    @PostMapping("create")
    public String processCreateCharacterForm(@ModelAttribute @Valid CharacterIdentity newCharacterIdentity,
                                             Errors errors){
        if(errors.hasErrors()){
            return "character/create";
        }

        characterIdentityRepository.save(newCharacterIdentity);

        return "redirect:";
    }

    @GetMapping("view/{characterId}")
    public String displayCharacterById(){
        return "view/{characterId}";
    }
}
