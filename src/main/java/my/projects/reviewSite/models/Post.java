package my.projects.reviewSite.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String theme;
    @Column(columnDefinition = "varchar(255)")
    private String preview;
    @Column(columnDefinition = "TEXT")
    private String text;

    public Post(String title, String theme, String text) {
        this.title = title;
        this.theme = theme;
        this.preview = (text.length() >= 90 ? text.substring(0, 90) : text) + "...";
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return id != null && Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
