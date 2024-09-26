package com.example.Springboot.service;

import com.example.Springboot.entity.Book;
import com.example.Springboot.entity.BookDTO;
import com.example.Springboot.entity.Review;
import com.example.Springboot.entity.ReviewDTO;
import com.example.Springboot.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 생성자주입
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<Book> getAllBooks(){
        return bookRepository.findAllWithReviews();
    }

    @Operation(summary = "Book조회", description = "책 조회 서비스")
    @Transactional(readOnly = true)
    public List<BookDTO> getAllBooksDTO(){
        // Book 정보와 Review 정보 함께 가져오는 단계

//        1. 서비스 계층에서 reviews 를 미리 로드하여,뷰 계층에서 LazyInitializationException 을 방지
//        List<Book> books = bookRepository.findAll(); //Book
//        books.forEach(book -> Hibernate.initialize(book.getReviews()));
//        return books;
        // n+1 문제를 해결하지 못하는 방식임
        // "모든" 데이터를 불러오는 방식이나, Eager와는 다르게 세션 안에서 불러오는 시점을 제어할수있다는 차이가 있음


//        2. JPQL을 이용해서 패치조인(fetch join) -> BookRepository
//        @Query("select b from Book b LEFT JOIN FETCH b.reviews")
//        public List<Book> findAllWithReviews();

//        3. Entity Graph를 이용 -> BookRepository
//        @EntityGraph(attributePaths = {"reviews"}) // 중괄호 안에 복수 입력 가능
//        @Query("select b from Book b")

        List<Book> books = bookRepository.findAllWithReviews();
        // Book <--순환참조--> Review (엔티티들)
        // 컨버팅 해줘야함
        List<BookDTO> bookDTOS = books.stream().map(this::convertToDTO).collect(Collectors.toList());

        return bookDTOS;
    }
    // Book -> BookDTO
    private BookDTO convertToDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPage(book.getPage());

        List<ReviewDTO> reviews = book.getReviews().stream().map(this::convertToDTO).collect(Collectors.toList());
        bookDTO.setReviews(reviews);

        return bookDTO;
    }
    // 오버로딩
    // Review -> ReviewDTO
    public ReviewDTO convertToDTO(Review review){

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setCost(review.getCost());
        reviewDTO.setContent(review.getContent());
        reviewDTO.setCreatedAt(review.getCreatedAt());
        return reviewDTO;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }
}
