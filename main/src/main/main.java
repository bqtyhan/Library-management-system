/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author batuh
 */
import java.util.Scanner;
public class main {
    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        do {            
           System.out.println("\nLibrary Management System:");
            System.out.println("1. Add a New Book");
            System.out.println("2. Register a New User");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display all Books");
            System.out.println("6. View Transactions");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    library.displayTransactions();
                    break;
                case 7:
                    System.out.println("Program exited successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            } 
        } while (true);
    }

    private static void addBook() {
        sc.nextLine(); // Tamponu temizlemek için eklenmiş
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Total Copies: ");
        int copies = sc.nextInt();
        library.addBook(title, author, copies);
    }

    private static void registerUser() {
        sc.nextLine(); // Tamponu temizlemek için eklenmiş
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        System.out.print("Enter User Email: ");
        String email = sc.nextLine();
        library.registerUser(name, email);
    }

    private static void borrowBook() {
         sc.nextLine(); // Tamponu temizlemek için eklenmiş
        System.out.print("Enter User Email: ");
        String userEmail = sc.nextLine();
        System.out.print("Enter Book Title: ");
        String bookTitle = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String bookAuthor = sc.nextLine();
        library.borrowBook(userEmail, bookTitle, bookAuthor);

    }

    private static void returnBook() {
        sc.nextLine(); // Tamponu temizlemek için eklenmiş
        System.out.print("Enter User Email: ");
        String userEmail = sc.nextLine();
        System.out.print("Enter Book Title: ");
        String bookTitle = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String bookAuthor = sc.nextLine();
        library.returnBook(userEmail, bookTitle, bookAuthor);
    }

    
}
