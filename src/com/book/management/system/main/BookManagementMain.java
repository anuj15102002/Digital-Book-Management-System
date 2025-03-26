package com.book.management.system.main;

import com.book.management.system.dto.BookDTO;
import com.book.management.system.library.services.LibraryService;

import java.util.Scanner;

public class BookManagementMain {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();

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
                    libraryService.addBook(new BookDTO(id, title, author, genre, availability));
                    break;
                case 2:
                    libraryService.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    libraryService.searchBook(scanner.nextLine());
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
                    libraryService.updateBook(bookId, new BookDTO(bookId, newTitle, newAuthor, newGenre, newAvailability));
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    libraryService.deleteBook(scanner.nextLine());
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
