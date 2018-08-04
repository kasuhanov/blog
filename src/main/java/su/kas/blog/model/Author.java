package su.kas.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Author {
    @Id
    @SequenceGenerator(name = "pk_author", sequenceName = "s_author", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_author")
    private long id;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();
}