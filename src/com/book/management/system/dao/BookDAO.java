package com.book.management.system.dao;
import com.book.management.system.dao.interfaces.BookDAOInterface;
import com.book.management.system.dto.*;
import java.util.*;

public class BookDAO implements BookDAOInterface {
    private final Map<String, BookDTO> books = new HashMap<>();

    @Override
    public void addBook(BookDTO bookDTO) {
        if (books.containsKey(bookDTO.getId())) {
            System.out.println("Book with this ID already exists.");
        } else {
            books.put(bookDTO.getId(), bookDTO);
            System.out.println("Book added successfully.");
        }
    }

    @Override
    public List<BookDTO> getAllBooks() {
        if(books.isEmpty())System.out.println("There are no books");
        return new ArrayList<>(books.values());

    }

    @Override
    public BookDTO getBookById(String id) {
        return books.get(id);

    }

    @Override
    public void updateBook(String id, BookDTO bookDTO) {
        if (books.containsKey(id)) {
            books.put(id, bookDTO);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }

    }

    @Override
    public void deleteBook(String id) {
        if (books.remove(id) != null) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}
