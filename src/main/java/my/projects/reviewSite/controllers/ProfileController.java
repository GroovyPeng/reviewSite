package my.projects.reviewSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage(
            Principal principal,
            Model model
    ) {
        model.addAttribute("title", "Профиль");
        model.addAttribute("username", principal.getName());
        return "profile";
    }
}
