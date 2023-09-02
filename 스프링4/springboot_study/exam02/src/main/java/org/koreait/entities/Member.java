package org.koreait.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.constants.Role;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name="es_member")
public class Member extends BaseEntity {
    @Id @GeneratedValue
    private Long userNo;
    @Column(length = 40, name="memId", unique = true, nullable = false) // notnull제약조건추가 -> nullable = false
    private String userId; // VARCHAR, VARCHAR2, NCHAR

    @Column(length = 65, nullable = false)
    private String userPw;

    @Column(length = 40, nullable = false)
    private String userNm;

    //@Lob
    @Transient // 테이블 필드에서 배제할때 (내부에서)사용
    private String introduction;

    @Enumerated(EnumType.STRING) // 기본값은 사용 안하는게 좋다!
    private Role type;



    /* 거의 사용X
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
     */
}
