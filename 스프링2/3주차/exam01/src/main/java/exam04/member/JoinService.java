package exam04.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    @Autowired
    private MemberDao memberDao;

    public void join(Member member){

        memberDao.register(member);
    }
}
