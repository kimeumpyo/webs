package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity{

    @Id @GeneratedValue
    public Long id;

    @Column(length = 40, nullable = false)
    private String poster;

    @Column(nullable = false)
    private String subject;

    @Lob
    private String content;
}
