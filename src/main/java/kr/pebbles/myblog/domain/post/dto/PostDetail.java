package kr.pebbles.myblog.domain.post.dto;

import kr.pebbles.myblog.domain.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDetail {

    private final String title;

    private final String subTitle;

    private final String author;

    private final String content;

    private final LocalDateTime createdAt;

    public PostDetail(Post post) {
        this.title = post.getTitle();
        this.subTitle = post.getSubTitle();
        this.author = post.getAuthor();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
    }

}
