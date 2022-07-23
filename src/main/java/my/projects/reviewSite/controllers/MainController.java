package my.projects.reviewSite.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    @GetMapping("/")
    public String Main(Model model) {
        model.addAttribute("title", "Review Site");
        return "main";
    }
}
