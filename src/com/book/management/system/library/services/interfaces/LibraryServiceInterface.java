package com.book.management.system.library.services.interfaces;

import com.book.management.system.dto.BookDTO;

public interface LibraryServiceInterface extends java.io.Serializable{
    void addBook(BookDTO bookDTO);
    void viewBooks();
    void searchBook(String id);


    void updateBook(String id, BookDTO bookDTO);
    void deleteBook(String id);
}
