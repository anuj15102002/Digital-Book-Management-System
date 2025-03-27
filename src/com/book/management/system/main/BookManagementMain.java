package com.book.management.system.main;

import com.book.management.system.dao.BookDAO;
import com.book.management.system.dto.*;
import com.book.management.system.enums.Availability;

import java.util.List;
import java.util.Scanner;

public class BookManagementMain {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        BookDAO bookDAO=new BookDAO();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine().trim();

// Check if the Book ID is empty
                    if (id.isEmpty()) {
                        System.out.println("Book ID cannot be empty.");
                        break;
                    }

// Check if the Book ID is already in use
                    if (bookDAO.getBookById(id)!=null) {
                        System.out.println("A book with this ID already exists. Please enter a unique ID.");
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine().trim();
                    if (author.isEmpty()) {
                        System.out.println("Author cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine().trim();
                    if (genre.isEmpty()) {
                        System.out.println("Genre cannot be empty.");
                        break;
                    }

                    System.out.print("Availability Status (AVAILABLE/CHECKED_OUT): ");
                    String statusInput = scanner.nextLine().trim().toUpperCase();

                    Availability availability;
                    try {
                        availability = Availability.valueOf(statusInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid availability status! Use AVAILABLE or CHECKED_OUT.");
                        break;
                    }

                    bookDAO.addBook(new BookDTO(id, title, author, genre, availability));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    List<BookDTO> books=bookDAO.getAllBooks();
                    for(BookDTO b: books)
                    {
                        System.out.println("Book id: "+b.getId());
                        System.out.println("Book Title: "+b.getTitle());
                        System.out.println("Book Author: "+b.getAuthor());
                        System.out.println("Book Genre: "+b.getAuthor());
                        System.out.println("Book Availability: "+b.getAvailablityStatus());
                        System.out.println("-----------------------------------------");
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    BookDTO book= bookDAO.getBookById(scanner.nextLine());
                    if(book==null)
                    {
                        System.out.println("Book not found");
                        break;
                    }
                    System.out.println("Book id: "+book.getId());
                    System.out.println("Book Title: "+book.getTitle());
                    System.out.println("Book Author: "+book.getAuthor());
                    System.out.println("Book Genre: "+book.getAuthor());
                    System.out.println("Book Availability: "+book.getAvailablityStatus());
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String bookId = scanner.nextLine().trim();

                    if (bookId.isEmpty()) {
                        System.out.println("Book ID cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine().trim();
                    if (newTitle.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine().trim();
                    if (newAuthor.isEmpty()) {
                        System.out.println("Author cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new Genre: ");
                    String newGenre = scanner.nextLine().trim();
                    if (newGenre.isEmpty()) {
                        System.out.println("Genre cannot be empty.");
                        break;
                    }

                    System.out.print("Availability Status (AVAILABLE/CHECKED_OUT): ");
                    String status = scanner.nextLine().trim().toUpperCase();

                    Availability newAvailability;
                    try {
                        newAvailability = Availability.valueOf(status);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid availability status! Use AVAILABLE or CHECKED_OUT.");
                        break;
                    }

                    bookDAO.updateBook(bookId, new BookDTO(bookId, newTitle, newAuthor, newGenre, newAvailability));
                    System.out.println("Book Updated");
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    bookDAO.deleteBook(scanner.nextLine());
                    System.out.println("Book deleted");
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        }
    }
}
