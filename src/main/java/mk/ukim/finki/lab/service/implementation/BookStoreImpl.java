package mk.ukim.finki.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.BookStore;
import mk.ukim.finki.lab.repository.jpa.BookStoreRepository;
import mk.ukim.finki.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookStoreImpl implements BookStoreService{

    private final BookStoreRepository bookStoreRepository;
    @Override
    public List<BookStore> listBookStores() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore findById(Long id) {
        return bookStoreRepository.findById(id).orElse(null);
    }
}
