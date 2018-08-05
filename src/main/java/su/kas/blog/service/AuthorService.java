package su.kas.blog.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import su.kas.blog.model.Author;
import su.kas.blog.model.Post;
import su.kas.blog.repository.AuthorRepository;
import su.kas.blog.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Post> findPostsOrderByDateTimeDesc(Author author) {
        return postRepository.findByAuthorOrderByDateTimeDesc(author);
    }
}
