package su.kas.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import lombok.AllArgsConstructor;
import su.kas.blog.service.AuthorService;
import su.kas.blog.service.PostService;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {
	private final AuthorService authorService;
	private final PostService postService;

	@GetMapping("/")
	public Rendering home() {
		return Rendering
				.view("index")
//                .modelAttribute("authors", authorService.findAll())
				.modelAttribute("posts", postService.findAll())
				.build();
	}
}
