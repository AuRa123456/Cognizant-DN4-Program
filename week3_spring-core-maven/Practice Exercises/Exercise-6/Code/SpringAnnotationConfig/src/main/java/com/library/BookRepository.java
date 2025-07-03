package com.library;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void printRepositoryStatus() {
        System.out.println("BookRepository (Annotation-based) is ready.");
    }
}
