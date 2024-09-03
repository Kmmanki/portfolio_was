package com.portfolio.exception.handler;

import com.portfolio.dto.ApiResultDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * 컨트롤러 예외처리 핸들러
 * date: 2024-07-29
 * author: 김만기
 *
 * ====== Annotation description ======
 * RestControllerAdvice: RestController에서 발생하는 예외를 처리하기 위한 annotation
 * ExceptionHandler: 특정 예외를 처리하기 위한 annotation
 * 
 * ====== method description ======
 * handleValidationExceptions: @size, @notnull 등에서 발생하는 예외를 처리
 *  400 Bad Request로 응답하고, data에는 @size 등에서 지정한 message=''를 담아서 전달
 */

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResultDto<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ApiResultDto<String> result = new ApiResultDto<>();
        result.setResultCode("400");
        result.setResultMessage("Validation Error");
        result.setData(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(result);
    }
}
