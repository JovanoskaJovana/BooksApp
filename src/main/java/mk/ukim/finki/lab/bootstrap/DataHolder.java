package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookStore;
import mk.ukim.finki.lab.model.Review;
import mk.ukim.finki.lab.repository.jpa.AuthorRepository;
import mk.ukim.finki.lab.repository.jpa.BookRepository;
import mk.ukim.finki.lab.repository.jpa.BookStoreRepository;
import mk.ukim.finki.lab.repository.jpa.ReviewRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataHolder {

    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<BookStore> bookStores = new ArrayList<>();
    public static List<Review> reviews = new ArrayList<>();


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    private final ReviewRepository reviewRepository;


    @PostConstruct
    public void init() {
        if (authorRepository.count() == 0) {
            authors.add(new Author(11L, "Jordan", "Peterson", "Dr. Peterson’s lectures and podcasts consistently attract large audiences, providing valuable insights into topics such as mythology, psychology, and personal development."));
            authors.add(new Author(22L, "Paulo", "Coelho", "Paulo Coelho is one of the most well-known authors in literary history. And much like his creative works, his personal story is full of twists and turns.He is most known for using complex symbolism to depict the journeys of his characters, who are typically motivated by spiritual beliefs. "));
            authors.add(new Author(33L, "Katerina", "Angelovska", "Avtor, sovetnik za licen razvoj, ucitel po Mindfulness (svesna) meditacija, Reiki master energetski trapevt, motivaciski govornik."));
            authors.add(new Author(44L, "Radovan", "Vitoshevikj", "Koavtor na knigata Budenje na svesta, toj e visokosvesno, kreativno i duhovno bitie koe se zanimava so licna i kolektivna preobrazba, sakan soprug i clen na prekrasno semejstvo. Toj veruva deka ovaa kniga ima mokj pozitivno da go transformira zivotot na site covecki bitija vo opstestvoto."));
            authorRepository.saveAll(authors);
        }

        if (bookStoreRepository.count() == 0) {
            bookStores.add(new BookStore("Literatura", "Skopje", "3-ta Makedonska Brigada"));
            bookStores.add(new BookStore("Akademska kniga", "Skopje", "Bulevar Partizanski odredi"));
            bookStores.add(new BookStore("Kultura-Gost", "Gostivar", "Brakja Ginoski"));
            bookStoreRepository.saveAll(bookStores);
        }

        if (bookRepository.count() == 0) {
            books.add(new Book("5871", "12 Rules for Life", "Self-help", 2018, new ArrayList<>(), bookStoreRepository.findAll().get(0)));
            books.add(new Book("3455", "Hippie", "Fiction", 2018, new ArrayList<>(), bookStoreRepository.findAll().get(1)));
            books.add(new Book("7364", "Budenje na svesta", "Self-help", 2019, new ArrayList<>(), bookStoreRepository.findAll().get(2)));
            //books.add(new Book("7364", "Budenje na svesta","Self-help", 2019, authors.subList(3,4))); lab
            bookRepository.saveAll(books);
        }

        if (reviewRepository.count() == 0) {
            reviews.add(new Review(5, "Fantastic book, total game changer for me to find the discipline I always wished I had. I read this book several years ago and it honestly has change my life in multiple positive ways and I cannot think of one negative way. ", bookRepository.findAll().get(0), LocalDateTime.of(2023, 5, 12, 15, 40, 5)));
            reviews.add(new Review(3, "I came to this book as a fan of Jordan Peterson, having enjoyed many of the podcasts, YouTube videos, interviews etc   However.", bookRepository.findAll().get(0), LocalDateTime.of(2021, 11, 9, 17, 10, 50)));
            reviews.add(new Review(4, "A fair r on what deficits they may willingly perceive or unwilling hold in the depths of the person.  ", bookRepository.findAll().get(0), LocalDateTime.of(2023, 8, 9, 20, 50, 26)));

           reviews.add(new Review(4, "Best of his that I’ve enjoyed for years. Authentic pieces, I guess because sort of autobiography. I ought to have been a hippy. Haha", bookRepository.findAll().get(1), LocalDateTime.of(2020, 2, 9, 20, 28, 3)));
           reviews.add(new Review(5, "Classic he 60s and tmade and changed history. Amazing book!!!", bookRepository.findAll().get(1), LocalDateTime.of(2019, 3, 10, 10, 8, 6)));
           reviews.add(new Review(3, "Paulo Coelho is an ex this aof a sudden, the book ends.", bookRepository.findAll().get(1), LocalDateTime.of(2019, 3, 10, 10, 8, 19)));


           reviews.add(new Review(5, "The book Awakening Consciousness is a complete guide for personal and collective transformation.", bookRepository.findAll().get(2), LocalDateTime.of(2021, 3, 27, 15, 5, 25)));
           reviews.add(new Review(4, "Its One Of The Book Which Is Very Deep And You Have To Give Proper Attention To It To Grasp All The Content. ", bookRepository.findAll().get(2), LocalDateTime.of(2020, 7, 18, 19, 15, 36)));
           reviews.add(new Review(5, "Affirmations for every chakra. Useful to have for everyday life. New age book for the believers. Noetic science proves affirmations work", bookRepository.findAll().get(2), LocalDateTime.of(2023, 1, 16, 12, 40, 52)));
           reviewRepository.saveAll(reviews);
        }



    }
}
