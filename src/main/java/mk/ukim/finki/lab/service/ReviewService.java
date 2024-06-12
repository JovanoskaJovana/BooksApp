package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.Review;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> listReviews();
    List<Review> listReviewsById(Long id);

    void saveReviews(int score, String description, Book book, LocalDateTime timestamp);

    List<Review> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to);

}
