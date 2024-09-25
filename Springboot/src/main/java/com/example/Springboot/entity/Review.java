package com.example.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cost;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    // FK(외래키)
    @ManyToOne // Review와 Book의 관계설정
    // JPA에게, Book book 은 테이블의 컬럼을 만들지 아니하고
    // FK로 만들어달라고 지시하는 내용
    @JoinColumn(name="book_id", referencedColumnName = "id", nullable = true) // 컬럼이름 book_id
    // 두번째는 생략가능. 생략시 기본적으로 PK를 사용
    // nullable 도 기본값 true
//    @JsonIgnore // 순환 참조를 해결하는 방법 1번째.
    private Book book; // Book_PK(id)
}
