package org.koreait.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.koreait.entities.Member;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class Exam01 {
    @PersistenceContext  // @Autowired
    private EntityManager em;

    @Test
    void test1() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .regDt(LocalDateTime.now())
                .build();

        em.persist(member); // member -> 영속성 컨텍스트 : 영속 상태 - 상태변화 감지
        em.flush();

        member.setUserNm("(수정)사용자01"); // 변경 -> UPDATE
        em.flush();

        em.remove(member);// 영속 상태 -> 제거 상태(제거 X) -> DELETE
        em.flush();
    }
}
