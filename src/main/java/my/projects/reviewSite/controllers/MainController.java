package my.projects.reviewSite.controllers;

import lombok.AllArgsConstructor;
import my.projects.reviewSite.models.Post;
import my.projects.reviewSite.services.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class MainController {
    final private PostService postService;

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        model.addAttribute("title", "Review Site");
        return "main";
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePost(@RequestParam Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}
