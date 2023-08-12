package controllers.member;

import lombok.Data;

@Data
public class JoinForm {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private String mobile;
    private boolean agree;
}
