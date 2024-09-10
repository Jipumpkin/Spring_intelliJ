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
public class Customer {

    private Long id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String rating;
    private int reserves;
    private Date created_at;


}
