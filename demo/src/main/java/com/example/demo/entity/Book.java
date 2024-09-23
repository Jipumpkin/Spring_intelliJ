package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA API -> create table book
// JPA API(엔진 : Hibernate)
// Object -> Table Mappring : ORM -> SQL 생성

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가 컬럼. db마다 문구가 다름
    private Long id;

    @Column(name = "title", unique = true, nullable = false, length = 40) // unique, notnull, 길이지정 등..
    private String title;


    private int price;
    private String author;
    private int page;
}
