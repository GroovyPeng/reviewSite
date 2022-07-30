package my.projects.reviewSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "profile";
    }
}
