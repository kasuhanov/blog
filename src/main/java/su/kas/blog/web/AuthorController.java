package su.kas.blog.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.AllArgsConstructor;
import su.kas.blog.model.Author;
import su.kas.blog.service.AuthorService;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public Rendering findAuthor(@PathVariable long id) {
        Author author = authorService.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return Rendering
                .view("author")
                .modelAttribute("author", author)
                .modelAttribute("posts", authorService.findPosts(author))
                .build();
    }

    @GetMapping("/")
    public List<Author> findAll(){
        return authorService.findAll();
    }
}
