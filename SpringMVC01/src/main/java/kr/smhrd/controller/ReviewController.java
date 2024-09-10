package kr.smhrd.controller;

import kr.smhrd.entity.Review;
import kr.smhrd.service.ReviewService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/reviewAdd")
    public String reviewAdd(Review review) {
        //리뷰등록
        reviewService.register(review);
        return "redirect:/bookView/"+review.getBook_id();
    }

    @GetMapping("/reviewRemove/{review_id}/{book_id}")
    public String reviewRemove(@PathVariable Long review_id, @PathVariable Long book_id) {
        reviewService.reviewRemove(review_id);
        return "redirect:/bookView/"+book_id;
    }
}
