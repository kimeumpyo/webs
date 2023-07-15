package exam03.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class MemberListService {
//    @Autowired // 필요한 객체를 알아서 주입해준다
    /*private MemberDao memberDao;

    @Autowired // Autowired를 이용해 setter로도 주입이 가능하다!
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }*/

    @Autowired
    @Qualifier("memberDao1")
    private Optional<MemberDao> opt;

    @Autowired
    private DateTimeFormatter formatter;

    public MemberListService(){}

    public MemberListService(MemberDao memberDao){
//        this.memberDao = memberDao;
    }

    @Autowired(required = false)
    public void setFormatter(DateTimeFormatter formatter){
        this.formatter = formatter;
    }

    public void print() {
        MemberDao memberDao = opt.get();
        List<Member> members = memberDao.gets();

        for (Member member : members) {
            if(formatter != null){
                member.setRegDtStr(formatter.format(member.getRegDt()));
            }
            System.out.println(member);
        }
    }
}
