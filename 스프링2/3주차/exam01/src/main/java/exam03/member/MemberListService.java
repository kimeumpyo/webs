package exam03.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

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
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MemberListService(){}

    public MemberListService(MemberDao memberDao){
//        this.memberDao = memberDao;
    }

    @Autowired(required = false)
//    @Autowired // 호출은 되지만 값은 null값
    public void setFormatter(@Nullable DateTimeFormatter formatter){
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
