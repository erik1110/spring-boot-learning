package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

// 繼承 ResponseEntityExceptionHandler 可以讓我們更容易地處理 Spring MVC 內建的例外
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 處理 @Valid 失敗時的 MethodArgumentNotValidException，並客製化錯誤響應結構。
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        // 1. 提取所有驗證錯誤細節
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // 2. 建立包含所有資訊的響應體 Map
        Map<String, Object> body = new LinkedHashMap<>();

        // 加入時間戳記
        body.put("timestamp", LocalDateTime.now());

        // 加入 HTTP 狀態碼
        body.put("status", status.value());

        // 加入錯誤類型
        body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());

        // 加入請求路徑
        // request.getDescription(false) 會得到類似 uri=/students
        String path = request.getDescription(false).substring(4);
        body.put("path", path);

        // 加入客製化的驗證錯誤細節 (這是您最想要的部分)
        body.put("error_messages", errors);

        // 3. 返回包含所有資訊的 ResponseEntity
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}