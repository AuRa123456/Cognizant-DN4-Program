package com.library;

public class BookService {
    private String name;
    private BookRepository bookRepository;

    public BookService(String name) {
        this.name = name;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayServiceDetails() {
        System.out.println("Service Name: " + name);
        if (bookRepository != null) {
            bookRepository.printRepositoryStatus();
        } else {
            System.out.println("BookRepository is not set.");
        }
    }
}
