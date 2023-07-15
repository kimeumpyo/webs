package exam02.member;

public class JoinService {

    private MemberDao memberDao = new MemberDao();


    public void join(Member member){

        memberDao.register(member);

    }
}
