package controllers.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {
    @NotBlank // 필수항목
    private String userId;

    @NotBlank // 필수항목
    private String userPw;
    private boolean saveId;
}
