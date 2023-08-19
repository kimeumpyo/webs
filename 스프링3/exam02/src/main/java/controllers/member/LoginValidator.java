package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.UserDao;
import models.member.Users;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // 알아서 주입!
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final UserDao userDao;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(LoginForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        LoginForm loginForm = (LoginForm) target;
        String userId = loginForm.getUserId();
        String userPw = loginForm.getUserPw();

        /*
            1. 아이디로 회원이 조회 되는지
            2. 조회된 회원의 비밀번호 일치여부
         */

//        1. 아이디로 회원이 조회 되는지
        if(userId == null || userId.isBlank() || userPw == null || userPw.isBlank()){
            return;
        }

        Users user = userDao.get(userId);
        if(user == null){ // 조회된 회원이 없는 경우
            errors.reject("NotFound");
        }else{ // 조회된 회원이 있는 경우 -> 비밀번호 일치여부 체크
            boolean matched = BCrypt.checkpw(userPw, user.getUserPw());
            if(!matched){// 비밀번호가 불일치
                errors.reject("NotFound");
            }
        }

    }
}
