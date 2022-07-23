package my.projects.reviewSite.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Theme {

    @Id
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Theme theme = (Theme) o;
        return name != null && Objects.equals(name, theme.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
