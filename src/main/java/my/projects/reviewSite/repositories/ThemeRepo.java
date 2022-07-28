package my.projects.reviewSite.repositories;

import my.projects.reviewSite.models.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepo extends CrudRepository<Theme, String> {
}
