package models.member;

import controllers.member.JoinForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserDao userDao;
    public void join(JoinForm joinForm){
        userDao.register(joinForm);
    }
}
