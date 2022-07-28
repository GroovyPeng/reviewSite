package my.projects.reviewSite.services;

import lombok.AllArgsConstructor;
import my.projects.reviewSite.repositories.ThemeRepo;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ThemeService {
    final private ThemeRepo themeRepo;

}
