package mk.ukim.finki.lab.service.implementation;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.repository.jpa.AuthorRepository;
import mk.ukim.finki.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> listAuthors() {

        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
