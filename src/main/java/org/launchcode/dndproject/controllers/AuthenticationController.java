package org.launchcode.dndproject.controllers;

import org.launchcode.dndproject.models.User;
import org.launchcode.dndproject.models.data.UserRepository;
import org.launchcode.dndproject.models.dto.LoginFormDTO;
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

    @GetMapping("userLogin")
    public String renderUserLoginForm(Model model){
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log in");
        return "/userLogin";
    }

    @PostMapping("userLogin")
    public String processUserLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                       Errors errors, HttpServletRequest request,
                                       Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "User Login");
            return "userLogin";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null){
            errors.rejectValue("username", "user.invalid", "The username or password is incorrect");
            model.addAttribute("title", "User Login");

            return "userLogin";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "The username or password is incorrect");
            model.addAttribute("title", "User Login");
            return "userLogin";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
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
            return "register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null){
            errors.rejectValue("username", "username.alreadyExists", "A user with that username already exists");
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

        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword(), registerFormDTO.getUserEmail(), registerFormDTO.getRoles());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }
}
