package mk.ukim.finki.lab.repository.inmemory;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
public class InMemoryAuthorRepository {
    List<Author> authors = new ArrayList<>(5);
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    public Optional<Author> findById(Long id) {
        return DataHolder.authors.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }
}
*/