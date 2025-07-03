package com.library;

import org.springframework.stereotype.Component;

@Component
public class LibraryService {
    public void processBooks() {
        System.out.println("Processing books...");
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
