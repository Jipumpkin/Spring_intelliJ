package com.example.Springboot.repository;

import com.example.Springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // 1. JPA에서 제공해주는 메서드(CRUD)
    // 2. Query Method
    // 3. JPQL(SQL을 직접 사용 가능) - select * from ~~ where ~~
    // 4. Querydsl(복잡한 SQL을 메서드 기반으로 사용) - X
    //      -> select().from().where("id=id")

}
