package my.projects.reviewSite.services;

import lombok.AllArgsConstructor;
import my.projects.reviewSite.models.Post;
import my.projects.reviewSite.repositories.PostRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    final private PostRepo postRepo;

    public void savePost(Post post) {
        postRepo.save(post);
    }

    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    public Iterable<Post> findAllPosts() {
        return postRepo.findAll();
    }

    public Optional<Post> findPostById(Long id) {
        return postRepo.findById(id);
    }
}
