package com.book.management.system.main;

import com.book.management.system.dao.BookDAO;
import com.book.management.system.dto.*;
import com.book.management.system.dto.interfaces.*;
import com.book.management.system.dao.interfaces.*;
import com.book.management.system.dto.*;

import java.util.List;
import java.util.Scanner;

public class BookManagementMain {
    public static void main(String args[])
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
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Is Available? (true/false): ");
                    boolean availability = scanner.nextBoolean();
                    scanner.nextLine();
                    bookDAO.addBook(new BookDTO(id, title, author, genre, availability));
                    break;
                case 2:
                    List<BookDTO> books=bookDAO.getAllBooks();
                    if(books.isEmpty())
                    {
                        System.out.println("No books are added");
                        break;
                    }
                    for(BookDTO b: books)
                    {
                        System.out.println("Book id: "+b.getId());
                        System.out.println("Book Title: "+b.getTitle());
                        System.out.println("Book Author: "+b.getAuthor());
                        System.out.println("Book Genre: "+b.getAuthor());
                        System.out.println("Book Availability: "+b.isAvailable());
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
                    System.out.println("Book Availability: "+book.isAvailable());
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Is Available? (true/false): ");
                    boolean newAvailability = scanner.nextBoolean();
                    scanner.nextLine();
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
