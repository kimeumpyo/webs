package org.koreait.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
//    @CreationTimestamp // insert시에 날짜와 시간이 자동
    @CreatedDate
    @Column(updatable = false) // insert때만 들어가고 수정(update)X
    private LocalDateTime regDt; // 등록일자

//    @UpdateTimestamp // update시에 날짜와 시간이 자동
    @LastModifiedDate
    @Column(insertable = false)// update때만 작용
    private LocalDateTime modDt; // 수정일자
}
