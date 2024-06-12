package mk.ukim.finki.lab.repository.jpa;


import mk.ukim.finki.lab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    public List<Review> findAll();

    public List<Review> findReviewsByBookId(Long bookId);

//    public void saveReview(Review review);
    List<Review> findAllByTimestampBetween(LocalDateTime from, LocalDateTime to);
}
