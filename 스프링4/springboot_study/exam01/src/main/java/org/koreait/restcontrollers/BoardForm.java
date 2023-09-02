package org.koreait.restcontrollers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardForm {
    @NotBlank(message="작성자를 입력하세요.")
    private String poster; // 작성자

    @NotBlank(message="제목을 입력하세요.")
    private String subject; // 제목

    @NotBlank(message="내용을 입력하세요.")
    private String content; // 내용
}
