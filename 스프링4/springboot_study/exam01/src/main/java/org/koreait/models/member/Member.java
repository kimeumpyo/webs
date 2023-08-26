package org.koreait.models.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor // 편법? 기본생성자가 같이 추가!
public class Member {
    private Long userNo;
    private String userId;

    @JsonIgnore // JSON 변환 제외
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ) // 형식 변환!
    private LocalDateTime regDt;

}
