package org.acme.entities;

import java.util.List;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @WithSession
    public Uni<List<Book>> findAll() {
        return bookRepository.findAll().list();
    }

    @WithTransaction
    public Uni<Book> add() {
        return bookRepository.persist(new Book("testBook"));
    }
}