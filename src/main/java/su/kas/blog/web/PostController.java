package su.kas.blog.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import su.kas.blog.service.PostService;
import su.kas.blog.web.exception.ResourceNotFoundException;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public String home(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found")));
        return "post";
    }
}
