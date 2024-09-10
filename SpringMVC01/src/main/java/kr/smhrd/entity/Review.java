package kr.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    private Long id; // 자동증가(AI)
    private Long book_id; // FK(외래키)
    private String content; // 내용
    private int rating; // 평점
    private Date created_at; // 작성일자
    private Long customer_id; // 포렌키(customer)

}
