package kr.pebbles.myblog.global.error.exception;

public class UnauthorizedException extends ServiceRuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }

}
