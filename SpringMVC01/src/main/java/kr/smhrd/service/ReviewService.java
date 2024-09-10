package kr.smhrd.service;

import kr.smhrd.entity.Review;
import kr.smhrd.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void register(Review review) {
        reviewRepository.save(review);
    }


    public List<Review> getByReviews(Long book_id){
        return reviewRepository.findAll(book_id);
    }

    public int getByRating(Long book_id){
        return reviewRepository.findByRating(book_id);
    }

    public void reviewRemove(Long id){
        reviewRepository.reviewDelete(id);
    }
}
