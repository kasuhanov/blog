package su.kas.blog.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import su.kas.blog.model.Author;
import su.kas.blog.service.AuthorService;
import su.kas.blog.web.exception.ResourceNotFoundException;

import java.util.List;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public String findAuthor(@PathVariable long id, Model model) {
        Author author = authorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        model.addAttribute("author", author);
        model.addAttribute("posts", authorService.findPostsOrderByDateTimeDesc(author));
        return "author";
    }

    @GetMapping("/")
    public List<Author> findAll() {
        return authorService.findAll();
    }
}
