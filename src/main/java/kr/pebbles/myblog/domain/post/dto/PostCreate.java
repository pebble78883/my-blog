package kr.pebbles.myblog.domain.post.dto;

import kr.pebbles.myblog.domain.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostCreate {

    @NotBlank
    @Size(max = 255)
    private String title;

    @Size(max = 255)
    private String subTitle;

    @Size(max = 1023)
    private String content;

    public PostCreate() {
    }

    public Post toEntity(String author) {
        return Post.builder()
                .title(title)
                .subTitle(subTitle)
                .content(content)
                .author(author)
                .build();
    }

}
