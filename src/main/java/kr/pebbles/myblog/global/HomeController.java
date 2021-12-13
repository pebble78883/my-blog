package kr.pebbles.myblog.global;


import kr.pebbles.myblog.domain.post.dao.PostFindDao;
import kr.pebbles.myblog.domain.post.dto.PostPreview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostFindDao postFindDao;

    @GetMapping
    public String home(Model model) {
        List<PostPreview> posts = postFindDao.findRecentlyPosts()
                .stream()
                .map(PostPreview::new)
                .collect(Collectors.toList());

        model.addAttribute("posts", posts);

        return "index";
    }

}
