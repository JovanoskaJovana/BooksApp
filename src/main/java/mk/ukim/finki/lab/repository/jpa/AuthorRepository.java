package mk.ukim.finki.lab.repository.jpa;


import mk.ukim.finki.lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
   public List<Author> findAll();

    public Optional<Author> findById(Long id);
}
