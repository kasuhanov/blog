package su.kas.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import su.kas.blog.model.Author;
import su.kas.blog.model.Post;
import su.kas.blog.repository.AuthorRepository;
import su.kas.blog.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JpaTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void testFindPostById() {
        Author author = new Author();
        author.setName("kasuhanov");
        authorRepository.save(author);
        Post post = new Post();
        post.setDateTime(LocalDateTime.now());
        post.setHeader("Lorem ipsum3");
        post.setContent("<b>Lorem ipsum</b> dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        post.setAuthor(author);
        postRepository.save(post);

        Optional<Post> found = postRepository.findById(post.getId());
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get()).isEqualTo(post);
    }

    @Test
    public void testFindAuthorById() {
        Author author = new Author();
        author.setName("kasuhanov");
        authorRepository.save(author);

        Optional<Author> found = authorRepository.findById(author.getId());
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get()).isEqualTo(author);
    }
}
