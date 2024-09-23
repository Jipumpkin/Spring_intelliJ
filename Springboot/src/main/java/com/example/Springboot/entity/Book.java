package com.example.Springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;
    private int price;
    private String author;
    private int page;

    // OneToMany : Lazy loading이 기본임
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 책 하나(One)이 여러개의 리뷰(Many)에 대해 관계가 있다.
    // mappedBy : 다른 테이블의 필드를 참조하고 있음을 명시
    // cascade : 부모 엔티티가 변할때 자식 엔티티가 어떻게될지 정하는 속성
    private List<Review> reviews; // 여러개가 담기기떄문에 List<>
}
