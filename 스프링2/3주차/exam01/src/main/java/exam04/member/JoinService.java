package exam04.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
//    @Autowired
    @NonNull
    private MemberDao memberDao;

//    public JoinService(MemberDao memberDao){ // => @Autowired 사용하지 않고!
//        this.memberDao = memberDao;
//    }

    public void join(Member member){

        memberDao.register(member);
    }
}
