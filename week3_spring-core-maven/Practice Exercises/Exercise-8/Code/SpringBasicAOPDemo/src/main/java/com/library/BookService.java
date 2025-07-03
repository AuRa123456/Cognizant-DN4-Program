package com.library;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performOperation() {
        System.out.println("Performing book operation...");
        bookRepository.save();
    }
}