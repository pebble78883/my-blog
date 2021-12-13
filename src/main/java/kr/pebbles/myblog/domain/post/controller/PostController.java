package kr.pebbles.myblog.domain.post.controller;

import kr.pebbles.myblog.domain.post.dao.PostFindDao;
import kr.pebbles.myblog.domain.post.dto.PostCreate;
import kr.pebbles.myblog.domain.post.entity.Post;
import kr.pebbles.myblog.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostFindDao postFindDao;
    private final PostService postService;

    @GetMapping
    public String list(Model model, @RequestParam(defaultValue = "1") final Integer pageNum) {
        final List<Post> posts = postFindDao.findAll(pageNum);
        model.addAttribute("posts", posts);

        return "posts/posts";
    }

    @GetMapping("/{postId}")
    public String show(Model model, @PathVariable final Long postId) {
        final Post post = postFindDao.findById(postId);
        model.addAttribute("post", post);

        return "posts/post";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("post", new PostCreate());
        return "posts/new";
    }

    @PostMapping("/new")
    public String create(RedirectAttributes model, final Principal principal, final PostCreate post) {
        final String author = principal.getName();
        final Long postId = postService.createPost(post, author);
        model.addAttribute("postId", postId);
        return "redirect:/posts/{postId}";
    }

}
