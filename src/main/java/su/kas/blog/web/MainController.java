package su.kas.blog.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import su.kas.blog.service.AuthorService;
import su.kas.blog.service.PostService;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {
    private final AuthorService authorService;
    private final PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }
}
