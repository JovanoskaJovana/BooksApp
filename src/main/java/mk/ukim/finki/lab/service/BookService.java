package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookStore;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);

    //List<Book> listBooksByAuthor(Long auhtorId);
    void saveBook(String isbn, String title, String genre, int year, List<Author> authors, String bookStore, Long id);
    void deleteBook(Long bookId);

    Book findBookById(Long id);


}