package org.koreait.restcontrollers;

import org.koreait.commons.CommonException;
import org.koreait.commons.rest.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.koreait.restcontrollers")
public class CommonRestController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData<Object>> errorHandler(Exception e){
        // e 객체가 CommonException으로부터 유래된 객체인지?
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        if(e instanceof CommonException){
            CommonException commonException = (CommonException)e;
            status = commonException.getStatus();
        }

        JSONData<Object> data = new JSONData<>();
        data.setSuccess(false);
        data.setStatus(status);
        data.setMessage(e.getMessage());

        return ResponseEntity
                .status(status)
                .body(data);
    }
}
