package kr.smhrd.repository;

import kr.smhrd.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper // 인터페이스는 자동으로 스캔이 되서 꼭 쓸 필요는 없다.(Repository에 인터페이스만 있을때)
@Repository
public interface BookRepository {
    // 책 전체 목록 가져오기
    public List<Book> findAll(); // SQL~

    public void save(Book book);

    public Book findById(Long id);

            // jpa에서 get은 find라는 키워드로 표현함
}
