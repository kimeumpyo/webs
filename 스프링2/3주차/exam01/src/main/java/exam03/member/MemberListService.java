package exam03.member;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberListService {
    @Autowired // 필요한 객체를 알아서 주입해준다
    private MemberDao memberDao;

    public MemberListService(){}

    public MemberListService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void print() {
        List<Member> members = memberDao.gets();

        for (Member member : members) {
            System.out.println(member);
        }
    }
}
