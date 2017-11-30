package su.kas.blog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import su.kas.blog.model.Post;
import su.kas.blog.repository.PostRepository;

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
}
