package exam04.member;

import java.util.List;

public class MemberListService {
    private MemberDao memberDao;

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
