package exam03.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class JoinService {
    @Autowired // 필요한 객체를 알아서 주입해준다
    @Qualifier("memberDao1")
    private MemberDao memberDao;

    public JoinService(){};

    public JoinService(MemberDao memberDao){
        this.memberDao = memberDao;
    }


    public void join(Member member){

        memberDao.register(member);
    }
}
