package exam04.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberListService {
//    @Autowired

    private  final MemberDao memberDao;

    /*
    private MemberDao memberDao;

    public MemberListService(MemberDao memberDao){ // => @Autowired 사용하지 않고!
        this.memberDao = memberDao;
    }
    */

    public void print() {
        List<Member> members = memberDao.gets();

        for (Member member : members) {
            System.out.println(member);
        }
    }
}
