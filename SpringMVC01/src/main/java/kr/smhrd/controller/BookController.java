package kr.smhrd.controller;

import kr.smhrd.entity.Book;
import kr.smhrd.entity.Review;
import kr.smhrd.service.BookService;
import kr.smhrd.service.ReviewService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// POJO(알바생)
@Controller
@RequiredArgsConstructor

//@RequestMapping("/api")
public class BookController {

    private final BookService bookService;
    private final ReviewService reviewService;
    // 책 전체목록 요청 처리
    @GetMapping("/bookList")
    public String bookList(Model model) {
        List<?> bookList = bookService.bookList();
        model.addAttribute("bookList", bookList);
        return "bookList"; // bookList.jsp , 뷰의 논리적인 이름 -> ${bookList}
    }

    @GetMapping("/bookRegister")
    public String bookRegister() {
        return "bookRegister"; // bookRegister.jsp
    }


    @PostMapping("/bookRegister")
                                // new Book()
    public String bookRegister(Book book) {

        bookService.register(book);
        return "redirect:/bookList"; // 다시 리스트 페이지로 가야된다.

    }

    @GetMapping("/bookView/{id}") // ?id=3 로도 가능
    public String bookView(@PathVariable Long id, Model model) {
        Book book=bookService.view(id);
        model.addAttribute("book", book);
        // 리뷰정보 가져오기~
        List<Review> reviews = reviewService.getByReviews(id);
        model.addAttribute("reviews", reviews);
        // 평균 평점 가져오기
        int avg_rating = reviewService.getByRating(id);
        model.addAttribute("avg_rating", avg_rating);
        return "bookView"; // bookView.jsp
    }
}
