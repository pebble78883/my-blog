package kr.pebbles.myblog.domain.post.dao;

import kr.pebbles.myblog.domain.post.entity.Post;
import kr.pebbles.myblog.domain.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostFindDao {

    private final PostRepository postRepository;

    public Post findById(final Long postId) {
        final Optional<Post> post = postRepository.findById(postId);
        post.orElseThrow(() -> new PostNotFoundException("post"));
        return post.get();
    }

    public List<Post> findRecentlyPosts() {
        return postRepository.findTop3ByOrderByIdDesc();
    }

    @Transactional(readOnly = true)
    public List<Post> findAll(final int pageNum) {
        final int DEFAULT_PER_PAGE = 5;
        final PageRequest pageRequest = PageRequest.of(pageNum - 1, DEFAULT_PER_PAGE, Sort.by(Sort.Direction.DESC, "id"));
        final Page<Post> posts = postRepository.findAll(pageRequest);

        return posts.getContent();
    }

}
