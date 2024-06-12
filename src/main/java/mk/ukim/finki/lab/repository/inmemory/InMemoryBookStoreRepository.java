package mk.ukim.finki.lab.repository.inmemory;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
@Repository
public class InMemoryBookStoreRepository {

    List<BookStore> bookStores = new ArrayList<>(5);
    public List<BookStore> findAll() {
        return DataHolder.bookStores;
    }

    public Optional<BookStore> findById(Long bookStoreId) {
        return DataHolder.bookStores.stream().filter(b -> b.getId().equals(bookStoreId)).findFirst();
    }

    public BookStore findBookStoreByNAme(String name) {
        return DataHolder.bookStores.stream()
                .filter(b -> b.getName().equals(name))
                .findFirst().orElse(null);
    }
}
*/