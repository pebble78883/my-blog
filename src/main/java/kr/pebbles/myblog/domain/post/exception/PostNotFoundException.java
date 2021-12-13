package kr.pebbles.myblog.domain.post.exception;

import kr.pebbles.myblog.global.error.exception.EntityNotFoundException;

public class PostNotFoundException extends EntityNotFoundException {

    public PostNotFoundException(String message) {
        super(message);
    }

}
