package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(@ModelAttribute User user, Model model, String verify) {

        // if statement to check if password matches verify
        if (user.getPassword().equals(verify)) {

            return "user/index";
            // if true - display welcome message
        } else {
            model.addAttribute("error", "error");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
            // if false - bail and redisplay the form
        }
    }
}
