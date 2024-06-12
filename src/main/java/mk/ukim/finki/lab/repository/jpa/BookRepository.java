package mk.ukim.finki.lab.repository.jpa;


import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findAll();

    public Book findByIsbn(String isbn);

//    public Author addAuthorToBook(Author author, Book book);

    public void deleteById(Long id);

//    public void saveBook(Book book);

    public Book findById(Long id);
}
