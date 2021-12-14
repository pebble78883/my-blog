package kr.pebbles.myblog.domain.post.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_id", updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String subTitle;

    @Column(length = 2000)
    private String content;

    @Column(length = 100)
    private String author;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Post(String title, String subTitle, String content, String author) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.author = author;
    }

}
