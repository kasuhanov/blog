package su.kas.blog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

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