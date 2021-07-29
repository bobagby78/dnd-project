package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.Character;
import org.launchcode.dndproject.models.data.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("character")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public String characterIndex(){
        return "character/index";
    }

    @GetMapping("create")
    public String renderCreateCharacterForm(Model model){
        model.addAttribute("title", "Create Character");
        model.addAttribute(new Character());

        return "character/create";
    }

    @PostMapping("create")
    public String processCreateCharacterForm(@ModelAttribute @Valid Character newCharacter,
                                             Errors errors, Model model){
        if(errors.hasErrors()){
            return "character/create";
        }

        characterRepository.save(newCharacter);

        return "redirect:";
    }

    @GetMapping("view/{characterId}")
    public String displayCharacterById(){
        return "view/{characterId}";
    }
}
