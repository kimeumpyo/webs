package models.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data @Builder
public class Users {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String mobile;
    private LocalDateTime regDt;
}
