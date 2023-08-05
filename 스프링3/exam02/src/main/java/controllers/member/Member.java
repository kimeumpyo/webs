package controllers.member;

import lombok.Data;

import java.util.List;

@Data
public class Member {
    private String userId;
    private String userPw;
    private String userPwRe;
    private String userNm;
    private List<String> hobby;
    private Address addr;
    private boolean agree;
}
