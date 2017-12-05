package su.kas.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

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
