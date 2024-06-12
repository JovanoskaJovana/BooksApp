package mk.ukim.finki.lab.web.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.service.implementation.AuthorServiceImpl;
import mk.ukim.finki.lab.service.implementation.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl authorService;
    private final BookServiceImpl bookService;

    @PostMapping("/author")
    public String authorsPage(
            @RequestParam (name = "bookIsbn") String isbn,
            Model model
    ) {
        model.addAttribute("authors", authorService.listAuthors());
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("bookIsbn", isbn);
        return "authorList";
    }

    @PostMapping("/addAuthorToBook")
    public String addAuthorToBook(
            @RequestParam(name = "authorId") Long authorId,
            @RequestParam(name = "bookIsbn") String isbn,
            Model model
    ) {
        bookService.addAuthorToBook(authorId, isbn);
        model.addAttribute("book", bookService.findBookByIsbn(isbn));
        return "bookDetails";
    }
}

