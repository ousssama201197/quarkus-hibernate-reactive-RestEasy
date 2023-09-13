package org.acme;

import java.util.List;

import org.acme.entities.Book;
import org.acme.entities.BookService;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class GreetingResource {

    private final BookService bookService;

    public GreetingResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public Uni<List<Book>> hello() {
        return bookService.findAll();
    }

    @GET
    @Path("/add")
    public Uni<Book> add() {
        return bookService.add();
    }
}
