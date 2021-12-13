package kr.pebbles.myblog.global.error.exception;

public class EntityNotFoundException extends ServiceRuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

}
