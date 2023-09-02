package org.koreait.models.board;

import org.koreait.commons.CommonException;
import org.springframework.http.HttpStatus;

public class NotAuthorizedException extends CommonException {
    public NotAuthorizedException(String message){
        super(message, HttpStatus.UNAUTHORIZED); // 401
    }
}
