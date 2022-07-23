package my.projects.reviewSite.controllers;

import lombok.AllArgsConstructor;
import my.projects.reviewSite.models.Post;
import my.projects.reviewSite.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {
    final private PostService postService;

    @GetMapping("/")
    public String Main(Model model) {
        Iterable<Post> posts = postService.findAllPosts();
        for (Post post : posts) {
            String postText = post.getText();
            post.setPreview((postText.length() >= 90 ? postText.substring(0, 90) : postText) + "...");
            postService.savePost(post);
        }
        model.addAttribute("posts", postService.findAllPosts());
        model.addAttribute("title", "Review Site");
        return "main";
    }

    @PostMapping("/")
    public String deletePost(@RequestParam Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}
