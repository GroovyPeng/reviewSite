package my.projects.reviewSite.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private String preview;
    @Column(columnDefinition = "TEXT")
    private String text;
    private Date date;

    public Post(String title, String theme, String text) {
        this.title = title;
        this.theme = theme;
        this.preview = text.length() >= 90 ? text.substring(0, 90) + "..." : text ;
        this.text = text;
        this.date = new Date();
    }
}
