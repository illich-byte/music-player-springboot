package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Показуємо форму реєстрації
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Обробляємо дані з форми
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        // Перевіряємо, чи логін зайнятий
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Користувач з таким іменем вже існує!");
            return "register";
        }

        // Хешуємо пароль перед збереженням в БД
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Зберігаємо в базу даних
        userRepository.save(user);

        return "redirect:/?success=true"; // Перенаправляє на головну сторінку з музикою
    }
}