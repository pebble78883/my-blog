package kr.pebbles.myblog.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 미리 정의 된 에러 발생 시 호출
     * 정의 된 에러 목록 : com.api.dailyseminar.common.error.ErrorCode
     */
//    @ExceptionHandler(ServiceRuntimeException.class)
//    protected String handleServiceRuntimeException(final ServiceRuntimeException e) {
//        final ErrorCode errorCode = e.getErrorCode();
//        log.warn("handleServiceRuntimeException: {}", errorCode.getMessage(), e);

//        final ApiResult apiResult = ApiResult.fail(errorCode);
//        return new ResponseEntity<>(apiResult, HttpStatus.valueOf(errorCode.getStatus()));
//    }

    /**
     * 명시적으로 핸들링 되지 않은 에러 발생 시 호출
     */
//    @ExceptionHandler(Exception.class)
//    protected String handleException(Exception e) {
//        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
//        return "";
//        final ApiResult apiResult = ApiResult.fail(ErrorCode.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}