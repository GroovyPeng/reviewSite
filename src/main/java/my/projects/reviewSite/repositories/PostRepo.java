package my.projects.reviewSite.repositories;

import my.projects.reviewSite.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
}
