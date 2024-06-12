package mk.ukim.finki.lab.repository.jpa;


import mk.ukim.finki.lab.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {
    public List<BookStore> findAll();

    public Optional<BookStore> findById(Long bookStoreId);

    public BookStore findBookStoreByName(String name);
}
