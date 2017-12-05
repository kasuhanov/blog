package su.kas.blog.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import su.kas.blog.model.Author;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
    boolean existsByName(String name);
}
