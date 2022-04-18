package org.launchcode.dndproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeetupController {

    @GetMapping("/meetup")
    private String displayMeetupPage(Model model){
        model.addAttribute("title", "Meetup");

        return "/meetup.html";
    }
}
