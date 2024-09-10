package kr.smhrd.repository;

import kr.smhrd.entity.Review;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository {

    public void save(Review review); // SQL~

    public List<Review> findAll(long book_id);

    public int findByRating(long book_id);

    @Delete("delete from review where id=#{id}")
    public void reviewDelete(long id);
}
