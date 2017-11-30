package su.kas.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.AllArgsConstructor;
import su.kas.blog.service.PostService;

@Controller
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public Rendering home(@PathVariable long id) {
        return Rendering
                .view("post")
                .modelAttribute("post",
                        postService.findById(id).orElseThrow(()->new RuntimeException("Post with id "+id+" not found")))
                .build();
    }
}
