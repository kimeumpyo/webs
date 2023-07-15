package exam02.member;

import java.util.List;

public class MemberListService {
    private MemberDao memberDao = new MemberDao();

    public void print() {
        List<Member> members = memberDao.gets();

        for (Member member : members) {
            System.out.println(member);
        }
    }
}
