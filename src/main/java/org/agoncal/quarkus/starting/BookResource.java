package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON) 
public class BookResource {
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("return all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks()
    {
        logger.info("the number of the books");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("return a single book with id " + id);
        return bookRepository.getBookById(id);
    }
}
