package com.book.management.system.library.services;

import com.book.management.system.dao.BookDAO;
import com.book.management.system.dto.BookDTO;
import com.book.management.system.library.services.interfaces.LibraryServiceInterface;

import java.util.List;

public class LibraryService implements LibraryServiceInterface {
    @Override
    public void addBook(BookDTO bookDTO) {
        BookDTO book = new BookDTO(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre(), bookDTO.isAvailable());
        BookDAO bookDAO=new BookDAO();
        bookDAO.addBook(book);
    }

    @Override
    public void viewBooks() {
        BookDAO bookDAO=new BookDAO();
        List<BookDTO> books = bookDAO.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (BookDTO book : books) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Genre: " + book.getGenre() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
            }
        }
    }

    @Override
    public void searchBook(String id) {
        BookDAO bookDAO=new BookDAO();
        BookDTO book = bookDAO.getBookById(id);
        if (book != null) {
            System.out.println("Book Found: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }

    @Override
    public void updateBook(String id, BookDTO bookDTO) {
        BookDAO bookDAO=new BookDAO();
        BookDTO updatedBook = new BookDTO(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre(), bookDTO.isAvailable());
        bookDAO.updateBook(id, updatedBook);
    }

    @Override
    public void deleteBook(String id) {
        BookDAO bookDAO=new BookDAO();
        bookDAO.deleteBook(id);

    }
}
