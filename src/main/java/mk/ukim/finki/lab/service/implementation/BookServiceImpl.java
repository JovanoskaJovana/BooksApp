package mk.ukim.finki.lab.service.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.repository.jpa.AuthorRepository;
import mk.ukim.finki.lab.repository.jpa.BookRepository;
import mk.ukim.finki.lab.repository.jpa.BookStoreRepository;
import mk.ukim.finki.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        /* Author author = authorRepository.findById(authorId).orElse(null);
        Book book = bookRepository.findByIsbn(isbn);
        book.getAuthors().add(author);
        bookRepository.save(book);
        return author;*/

        Author author = authorRepository.findById(authorId).orElse(null);
        Book book = bookRepository.findByIsbn(isbn);

        if (!author.getBooks().contains(book)) {
            author.getBooks().add(book);
        }

        if(!book.getAuthors().contains(author)) {
            book.getAuthors().add(author);
        }

        bookRepository.save(book);
        authorRepository.save(author);
        return author;
    }


    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    @Transactional
    public void saveBook(String isbn, String title, String genre, int year, List<Author> authors, String bookStoreName, Long id) {
        if (id != null) {
            bookRepository.deleteById(id);
            bookRepository.save(new Book(isbn, title, genre, year, null, bookStoreRepository.findBookStoreByName(bookStoreName)));
            return;
        }
        bookRepository.save(new Book(isbn, title, genre, year, null, bookStoreRepository.findBookStoreByName(bookStoreName)));
    }



    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book copyBook(Long id) {
        Book oldBook  = bookRepository.findById(id);
        Book copyBook = new Book();

        if (oldBook != null) {
            copyBook.setTitle("Copy of - " + oldBook.getTitle());
            copyBook.setIsbn(oldBook.getIsbn());
            copyBook.setBookStore(oldBook.getBookStore());
            copyBook.setYear(oldBook.getYear());
            copyBook.setGenre(oldBook.getGenre());
            copyBook.setId((long) (Math.random()*1000));
            bookRepository.save(copyBook);
        }
        return copyBook;

    }

}




// @Override
//public List<Book> listBooksByAuthor(Long auhtorId) {
// Author author = authorRepository.findById(auhtorId).orElse(null);
//List<Book> book = bookRepository.findAll();

//return book.stream()
//      .filter(b -> b.getAuthors().contains(author))
//    .collect(Collectors.toList());
//} lab