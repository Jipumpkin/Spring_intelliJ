package kr.smhrd.service;
// POJO : 비즈니스로직을 처리

import kr.smhrd.entity.Book;
import kr.smhrd.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    //@Autowired
    private final BookRepository bookRepository;
    // 기능정의...(crud)
    // 책 전체 목록을 가져오기
    public List<Book> bookList() {
        // 추가적인 로직을 구현...

        return bookRepository.findAll();
    }

    // 책 등록 메서드
    public void register(Book book) {
        bookRepository.save(book);
    }

    public Book view(Long id){
        //추가 로직이 있다면 여기에 작성. 현재는 컨트롤러의 의미가 없는 상태
        return bookRepository.findById(id);
    }
}
