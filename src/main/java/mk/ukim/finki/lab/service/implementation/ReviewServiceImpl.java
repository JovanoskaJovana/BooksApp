package mk.ukim.finki.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.Review;
import mk.ukim.finki.lab.repository.jpa.ReviewRepository;
import mk.ukim.finki.lab.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> listReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> listReviewsById(Long bookId) {
        return reviewRepository.findReviewsByBookId(bookId);
    }

    @Override
    public void saveReviews(int score, String description, Book book, LocalDateTime timestamp) {
        reviewRepository.save(new Review(score, description, book, timestamp));
    }

    @Override
    public List<Review> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        return reviewRepository.findAllByTimestampBetween(from,to);
    }


}
