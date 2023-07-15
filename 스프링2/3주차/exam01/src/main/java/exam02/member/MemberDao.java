package exam02.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
    // 저장하는 메모리
    private static Map<String, Member> data = new HashMap<>();

    // 레지스터 생성
    public void register(Member member) {
        String userId = member.getUserId();

        data.put(userId, member);
    }

    // 유저의 아이디를 가지고 회원을 조회!
    public Member get(String userId) {
        return data.get(userId);
    }

    public List<Member> gets() {
        List<Member> members = new ArrayList(data.values());

        return members;
    }
}
