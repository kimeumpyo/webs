package exam02.member;

public class JoinService {

    private MemberDao memberDao = new CachedMemberDao();


    public void join(Member member){

        memberDao.register(member);

    }
}
