package com.example.onlinesurgalt.controller;

import com.example.onlinesurgalt.model.Dtos.UserDTO;
import com.example.onlinesurgalt.model.auth.User;
import com.example.onlinesurgalt.repository.auth.RoleRepository;
import com.example.onlinesurgalt.repository.auth.UserRepository;
import com.example.onlinesurgalt.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final RoleRepository roleRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    @Autowired
    public UserController(RoleRepository roleRepository, UserRepository userRepository, AuthenticationManager authenticationManager, UserService userService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        List<String> levels = new ArrayList<>();
        levels.add("BEGINNER");
        levels.add("INTERMEDIATE");
        levels.add("ADVANCED");

        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", new User());
        model.addAttribute("levels", levels);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserDTO userDTO) {
        userService.save(new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getLevel(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getAge(),
                userDTO.getRoles())
        );
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        User user = userService.getCurrentUser(); // Fetch the logged-in user
        if (user == null) {
            return "redirect:/login"; // Redirect if not authenticated
        }
        model.addAttribute("user", user);
        return "profile"; // Matches `profile.html`
    }




    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
