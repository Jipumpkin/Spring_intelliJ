package com.example.Springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
// @Entity Data ----(변환작업이 필요)-----> DTO
public class BookDTO {

    private Long id;
    private String title;
    private int price;
    private String author;
    private int page;
    private List<ReviewDTO> reviews;


}