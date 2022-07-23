package my.projects.reviewSite.controllers;

import lombok.AllArgsConstructor;
import my.projects.reviewSite.models.Post;
import my.projects.reviewSite.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class PostController {
    final private PostService postService;

    @GetMapping("/post-add")
    public String postAdd(Model model) {
        model.addAttribute("title", "Добавление поста");
        return "post-add";
    }

    @PostMapping("/post-add")
    public String newPost(
            @RequestParam String title,
            @RequestParam String theme,
            @RequestParam String text
    ) {
        postService.savePost(new Post(title, theme, text));
        return "success";
    }

    @GetMapping("/{theme}/{id}")
    public String detailsPost(
            @PathVariable(value = "id") String theme,
            @PathVariable(value = "id") Long id,
            Model model
    ) {
        Optional<Post> optionalPost = postService.findPostById(id);
        if ( optionalPost.isEmpty() ) {
            model.addAttribute("title", "Пост не найден!");
            return "post-not-found";
        }

        Post post = optionalPost.get();
        model.addAttribute("title", post.getTitle());
        model.addAttribute("post", post);
        return "post-details";
    }

}
