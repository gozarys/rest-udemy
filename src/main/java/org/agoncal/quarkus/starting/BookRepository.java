package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class BookRepository {
    
    @ConfigProperty(name = "books.genre", defaultValue = "Sci-fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "quarkus", "Antonio", 2020, genre),
            new Book(2, "toto", "Antonio", 2021, genre),
            new Book(3, "java", "Josh", 2022, genre),
            new Book(4, "thçinking", "Bruce", 2029, genre)
        );
    }

        public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBooks().stream()
                .filter(book -> book.id == id)
                .findFirst();
    }
}
