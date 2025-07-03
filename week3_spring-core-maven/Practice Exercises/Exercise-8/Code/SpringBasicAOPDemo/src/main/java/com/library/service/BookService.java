package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public void displayBook() {
        System.out.println("BookService: Displaying book...");
    }
}
