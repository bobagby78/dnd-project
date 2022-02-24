package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.DndCharacter;
import org.launchcode.dndproject.models.data.DndCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("character")
public class CharacterController {

    @Autowired
    private DndCharacterRepository dndCharacterRepository;

    @GetMapping
    public String characterIndex(){
        return "character/index";
    }

    @GetMapping("create")
    public String renderCreateCharacterForm(Model model){
        ArrayList<String> characterClasses = new ArrayList<String>(Arrays.asList("barbarian", "bard", "cleric", "druid", "fighter", "monk", "paladin", "ranger", "rogue", "sorcerer", "warlock", "wizard"));
        model.addAttribute(characterClasses);
        model.addAttribute("title", "Create Character");
        model.addAttribute(new DndCharacter());
        model.addAttribute("");

        System.out.println(characterClasses);

        return "character/create";
    }

    @PostMapping("create")
    public String processCreateCharacterForm(@ModelAttribute @Valid DndCharacter newDndCharacter,
                                             Errors errors){
        if(errors.hasErrors()){
            return "character/create";
        }

        dndCharacterRepository.save(newDndCharacter);

        return "redirect:";
    }

    @GetMapping("view/{dndCharacterId}")
    public String displayCharacterById(Model model, @PathVariable int dndCharacterId){

        Optional optionalDndCharacter = dndCharacterRepository.findById(dndCharacterId);
        if (optionalDndCharacter.isPresent()){
            DndCharacter dndCharacter = (DndCharacter) optionalDndCharacter.get();
            model.addAttribute("title", "View Character Stats");
            model.addAttribute("dndCharacter", dndCharacter);
        }

        return "character/view";
    }
}
