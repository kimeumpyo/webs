package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final UserDao userDao;
    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.isAssignableFrom(JoinForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm) target;
        /*
            1. 아이디 중복 여부
            2. 비밀번호와 비빌번호 확인 일치 여부
            3. 휴대전화번호는 필수 X, 입력된 경우는 형식 체크
         */

//        1. 아이디 중복 여부
        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String mobile = joinForm.getMobile();

        if (userId != null && !userId.isBlank() && userDao.exists(userId)){
            errors.rejectValue("userId", "duplicate");
        }

//        2. 비밀번호와 비빌번호 확인 일치 여부
        if (userPw != null && !userPw.isBlank() && userPwRe != null && !userPwRe.isBlank()
        && !userPw.equals(userPwRe)){
            errors.rejectValue("userPwRe", "incorrect");
        }

//        3. 휴대전화번호는 필수 X, 입력된 경우는 형식 체크
//        010 0000 0000, 010-0000-0000, 010.0000.0000
//        016 000 0000

        if(mobile != null && !mobile.isBlank()){
            mobile = mobile.replaceAll("\\D", ""); // 숫자가 아닌 문자열 제거 -> 숫자만 남는다.

            // ^시작 $끝 d:숫자(3자리~4자리)
            String pattern = "^01[016]\\d{3,4}\\d{4}$";
            if(!mobile.matches(pattern)){ // 패턴에 일치 하지 않는 경우 : 휴대전화번호 형식 X
                errors.rejectValue("mobile", "incorrect");
            }
            joinForm.setMobile(mobile);
        }

        /** 필수 항목 - userId, userPw, userPwRe, UserNm **/
        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPwRe", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNm", "required");


        if(!joinForm.isAgree()){
            errors.rejectValue("agree", "required");
        }
        */

        /*
        boolean result = false;
        if(!result){
            errors.reject("commonError", "공통 에러 발생!");
        }
        */
    }
}
