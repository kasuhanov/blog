package su.kas.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @SequenceGenerator(name = "pk_post", sequenceName = "s_post", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_post")
    private long id;
    private String content;
    @Column(length = 10000)
    private String header;
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
