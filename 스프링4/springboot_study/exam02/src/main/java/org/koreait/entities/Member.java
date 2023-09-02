package org.koreait.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Member {
    @Id
    private Long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private LocalDateTime regDt; // 등록일자
    private LocalDateTime modDt; // 수정일자
}
