package org.koreait.restcontrollers;

import lombok.Data;

@Data
public class BoardForm {
    private String poster; // 작성자
    private String subject; // 제목
    private String content; // 내용
}
