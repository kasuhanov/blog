package su.kas.blog.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import su.kas.blog.model.Post;
import su.kas.blog.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findAllOrderByDateTimeDesc() {
        return postRepository.findAllByOrderByDateTimeDesc();
    }
}
