package org.koreait.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void init(){
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
//                .regDt(LocalDateTime.now())
                .build();

        em.persist(member);
        em.flush();
    }

    @Test
    void test1() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
//                .regDt(LocalDateTime.now())
                .build();

        em.persist(member); // member -> 영속성 컨텍스트 : 영속 상태 - 상태변화 감지
        em.flush();

        em.detach(member); // 영속성 분리 -> 상태변화 감지 X

        member.setUserNm("(수정)사용자01"); // 변경 -> UPDATE

        em.merge(member); // 분리된 영속 상태 -> 영속 상태 - 상태 변화 감지

        em.flush();

/*
        em.remove(member);// 영속 상태 -> 제거 상태(제거 X) -> DELETE
        em.flush();

 */
    }
    @Test
    void test2(){
        // em.clear(); // 영속성 컨텍스트에 있는 엔티티 비우기

        Member member = em.find(Member.class, 1L);
        System.out.println(member);

        member.setUserNm("(수정)사용자01");

        Member member2 = em.find(Member.class, 1L); // 엔티티에 변화 있는 상태 -> find 조회,
        // flush() 를 추가 안해도 조회전 flush(); 자동 호출
        System.out.println(member2);
        System.out.println(member == member2);
    }
}
