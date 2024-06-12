package mk.ukim.finki.lab.repository.inmemory;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
@Repository
public class InMemoryBookRepository {
    List<Book> books = new ArrayList<>(5);

    public List<Book> findAll() {
        return DataHolder.books;
    }

    public Book findByIsbn(String isbn) {
        return DataHolder.books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst().orElse(null);
    }

    public Author addAuthorToBook(Author author, Book book){
        if (!book.getAuthors().contains(author)) {
            book.getAuthors().add(author);
        }
        return author;
    }

    public void deleteById(Long id) {
        Optional<Book> bookOptional = DataHolder.books.stream().
                filter(b -> b.getId().equals(id))
                .findFirst();

        bookOptional.ifPresent(book -> DataHolder.books.remove(book));
    }

    public void saveBook(Book book) {
        Optional<Book> bookOptional = DataHolder.books.stream()
                .filter(b -> b.getId().equals(book.getId()))
                .findFirst();

        if (bookOptional.isEmpty()){
            DataHolder.books.add(book);
        }
    }

    public Book findById(Long id) {
        return DataHolder.books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
    }
}
*/