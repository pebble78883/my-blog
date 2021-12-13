package kr.pebbles.myblog.domain.post.service;

import kr.pebbles.myblog.domain.post.dao.PostRepository;
import kr.pebbles.myblog.domain.post.dto.PostCreate;
import kr.pebbles.myblog.domain.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Long createPost(final PostCreate postCreate, final String author) {
        Post post = postCreate.toEntity(author);
        postRepository.save(post);
        return post.getId();
    }

}
