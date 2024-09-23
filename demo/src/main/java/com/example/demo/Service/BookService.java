package com.example.demo.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public List<Book> findAll(){
        return bookRepository.findAll(); // select * from Book : 제너레이션. JPQL->SQL 전송
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id); // delete from Book b where b.id=?1
    }

    public Book save(Book book){
        return bookRepository.save(book); // insert into Book ~~
    }

    public Book findById(Long id){

        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent()){
            return optional.get(); //
        }else{
            throw new RuntimeException("Book not found with id:"+id);
        }
    }

    @Transactional
    public Book update(Long id, Book book){
        Optional<Book> optional = bookRepository.findById(book.getId());
        if(optional.isPresent()){
            Book dbBook = optional.get(); // DB에서 가져온 Book
            dbBook.setPrice(book.getPrice());
            dbBook.setPrice(book.getPrice());
            dbBook.setAuthor(book.getAuthor());
            dbBook.setPage(book.getPage());
            // bookRepository.save(dbBook); // update SQL // 주석처리하여 save 하지 않아도 set을 통해 jpa가 업데이트를 해준다. 따라서 명시적인 부분임
            return dbBook; // 수정이 되는 부분 (더티채킹)
        }else{
            throw new RuntimeException("Book not found with id:"+id);
        }

    }
}
