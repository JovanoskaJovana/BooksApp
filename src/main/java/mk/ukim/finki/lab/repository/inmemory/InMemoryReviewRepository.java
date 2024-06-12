package mk.ukim.finki.lab.repository.inmemory;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Review;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
@Repository
public class InMemoryReviewRepository {

    public List<Review> findAll() {
        return DataHolder.reviews;
    }

    public List<Review> findBookById(Long id) {
        return DataHolder.reviews.stream()
                .filter(r -> r.getBook().getId().equals(id))
                .collect(Collectors.toList());
    }

    public void saveReview(Review review) {
        Optional<Review> saveReview = DataHolder.reviews.stream()
                .filter(r -> r.getId().equals(review.getId()))
                .findFirst();

        if (saveReview.isEmpty()) {
            DataHolder.reviews.add(review);
        }

    }
}

 */