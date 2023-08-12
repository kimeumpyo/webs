package controllers.member;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class JoinValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(JoinForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm) target;

        /** 필수 항목 - userId, userPw, userPwRe, UserNm **/
        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String userNm = joinForm.getUserNm();

        if (userId == null || userId.isBlank()) { // isBlank(빈공간일경우!)
            errors.rejectValue("userId", "required");
        }

        if (userPw == null || userPw.isBlank()) {
            errors.rejectValue("userPw", "required");
        }

        if (userPwRe == null || userPwRe.isBlank()) {
            errors.rejectValue("userPwRe", "required");
        }

        if (userNm == null || userNm.isBlank()) {
            errors.rejectValue("userNm", "required");
        }

        if(!joinForm.isAgree()){
            errors.rejectValue("agree", "required");
        }
        /*
        boolean result = false;
        if(!result){
            errors.reject("commonError", "공통 에러 발생!");
        }
        */
    }
}
