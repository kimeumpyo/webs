<%@ page contentType="text/html; charset=UTF-8" %>
${title}

<form method="POST">
    <dl>
        <dt>아이디</dt>
        <dd>
            <input type="text" name="userId">
        </dd>
    </dl>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <input type="password" name="userPw">
        </dd>
    </dl>
    <dl>
         <dt>비밀번호 확인</dt>
         <dd>
             <input type="password" name="userPwRe">
         </dd>
    </dl>
    <dl>
         <dt>회원명</dt>
         <dd>
             <input type="text" name="userNm">
         </dd>
    </dl>
    <dl>
         <dt>취미</dt>
         <dd>
             <input type="checkbox" name="hobby" value="축구">축구
             <input type="checkbox" name="hobby" value="야구">야구
             <input type="checkbox" name="hobby" value="농구">농구
             <input type="checkbox" name="hobby" value="수영">수영
             <input type="checkbox" name="hobby" value="독서">독서
        </dd>
    </dl>
        <dt>주소</dt>
        <dd>
             우편번호 : <input type="text" name="addr.zipcode">
             <br>
             주소 : <input type="text" name="addr.addr1">
             <br>
             나머지 주소 : <input type="text" name="addr.addr2">
        </dd>
    <dl>

    </dl>
    <div>
        <input type="checkbox" name="agree" value="true" id="agree">
        <label for="agree">약관에 동의합니다.</label>
    </div>
    <button type="submit">가입하기</button>
</form>