package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinForm {
    //    @NotBlank(message = "아이디를 입력하세요.") // null이 아니고 최소한 한 개 이상의 공백아닌 문자를 포함하는지 검사한다.
    @NotBlank //resources ->  messages ->commons.properties
    @Size(min = 6, max = 16) // 최소6자리, 최대16자리
    private String userId;

    @NotBlank
    @Size(min = 8)// 최소8자리
    private String userPw;

    @NotBlank
    private String userPwRe;

    @NotBlank
    private String userNm;
    private String mobile;

    @AssertTrue // 값이 true인지 또는 false인지 검사한다
    private boolean agree;
}
