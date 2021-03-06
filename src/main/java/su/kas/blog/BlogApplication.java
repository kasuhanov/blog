package su.kas.blog;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import su.kas.blog.model.Author;
import su.kas.blog.model.Post;
import su.kas.blog.repository.AuthorRepository;
import su.kas.blog.repository.PostRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader loader) {
        return Mustache.compiler()
                .escapeHTML(false)
                .withLoader(loader);
    }

    @Bean
    public CommandLineRunner clr(final AuthorRepository authorRepository, final PostRepository postRepository) {
        return args -> {
            if (!authorRepository.existsByName("kasuhanov")) {
                Author author = new Author();
                author.setName("kasuhanov");
                authorRepository.save(author);
                Post post = new Post();
                post.setDateTime(LocalDateTime.now());
                post.setHeader("Lorem ipsum");
                post.setContent("**Lorem ipsum** dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                        " http://localhost:8080/");
                post.setAuthor(author);
                postRepository.save(post);

                post = new Post();
                post.setDateTime(LocalDateTime.now());
                post.setHeader("Lorem ipsum2");
                post.setContent("**Lorem ipsum** dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua.");
                post.setAuthor(author);
                postRepository.save(post);

                post = new Post();
                post.setDateTime(LocalDateTime.now());
                post.setHeader("Lorem ipsum3");
                post.setContent("**Lorem ipsum** dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua.");
                post.setAuthor(author);
                postRepository.save(post);

                post = new Post();
                post.setDateTime(LocalDateTime.now());
                post.setHeader("Lorem ipsum4");
                post.setContent("**Lorem ipsum** dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua.");
                post.setAuthor(author);
                postRepository.save(post);
            }
        };
    }
}
