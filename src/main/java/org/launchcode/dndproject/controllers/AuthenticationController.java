package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.User;
import org.launchcode.dndproject.models.data.UserRepository;
import org.launchcode.dndproject.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession (HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null){
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()){
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("auth")
    public String renderAuthForm(Model model){
        model.addAttribute("title", "Log in");
        return "/auth";
    }

    @GetMapping("register")
    public String renderRegistrationForm(Model model){
        model.addAttribute("title", "Register");
        model.addAttribute(new RegisterFormDTO());
        return "/register";
    }

    @PostMapping("register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return" register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null){
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";

        }

        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword(), registerFormDTO.getUserEmail());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }
}
