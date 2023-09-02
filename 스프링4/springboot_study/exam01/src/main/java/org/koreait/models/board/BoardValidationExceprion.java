package org.koreait.models.board;

import org.koreait.commons.CommonException;
import org.springframework.http.HttpStatus;

public class BoardValidationExceprion  extends CommonException {
    public BoardValidationExceprion(String message){
        super(message, HttpStatus.BAD_REQUEST); // 400
    }
}
