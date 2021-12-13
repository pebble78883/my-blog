package kr.pebbles.myblog.domain.post.dto;

import kr.pebbles.myblog.domain.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostPreview {

    private final String title;

    private final String subTitle;

    private final String author;

    private final LocalDateTime createdAt;

    public PostPreview(Post post) {
        this.title = post.getTitle();
        this.subTitle = post.getSubTitle();
        this.author = post.getAuthor();
        this.createdAt = post.getCreatedAt();
    }

}
