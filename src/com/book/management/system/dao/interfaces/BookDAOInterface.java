package com.book.management.system.dao.interfaces;

import com.book.management.system.dto.BookDTO;

import java.util.List;


public interface BookDAOInterface extends java.io.Serializable{

    void addBook(BookDTO book);
    List<BookDTO> getAllBooks();

    BookDTO getBookById(String id);
    void updateBook(String id, BookDTO updatedBook);
    void deleteBook(String id);
}
