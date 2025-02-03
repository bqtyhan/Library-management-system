/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author batuh
 */


// The User class represents a library user
class User {
    private String name,email;                // Name of the user and Email address of the user             
    private Book[] borrowedBooks;       // Array to store books borrowed by the user
    private int borrowedCount;          // Number of books currently borrowed by the user

    // Constructor to initialize a user
    public User(String name, String email) {
        this.name = name;                             // Set the user's name
        this.email = email;                           // Set the user's email
        this.borrowedBooks = new Book[5];            // Allow up to 5 books to be borrowed
        this.borrowedCount = 0;                      // Initially, no books are borrowed
    }

    // Getter for the user's name
    public String getName() {
        return name;
    }

    // Getter for the user's email
    public String getEmail() {
        return email;
    }

    /**
     * Method to borrow a book.
     * @param book The book to be borrowed.
     * @return True if the book was successfully borrowed, false otherwise.
     */
    public boolean borrowBook(Book book) {
        if (borrowedCount < 5) {                      // Check if the user has not exceeded the borrowing limit
            borrowedBooks[borrowedCount++] = book;    // Add the book to the borrowedBooks array
            return true;                              // Return true for a successful borrow
        }
        System.out.println("Cannot borrow more than 5 books."); // Print a message if limit is exceeded
        return false;                                 // Return false for unsuccessful borrow
    }

    /**
     * Method to return a book.
     * @param book The book to be returned.
     * @return True if the book was successfully returned, false otherwise.
     */
    public boolean returnBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {     // Iterate over borrowed books
            if (borrowedBooks[i] == book) {           // Check if the book is found in the user's borrowed books
                borrowedBooks[i] = borrowedBooks[--borrowedCount]; // Remove the book and adjust the array
                return true;                          // Return true for a successful return
            }
        }
        System.out.println("This book was not borrowed by the user."); // Print a message if the book was not found
        return false;                                // Return false for unsuccessful return
    }

    /**
     * Method to get all borrowed books.
     * @return An array of borrowed books.
     */
    public Book[] getBorrowedBooks() {
        return borrowedBooks;                        // Return the array of borrowed books
    }

    /**
     * Method to check if the user has borrowed a specific book.
     * @param book The book to check.
     * @return True if the book is borrowed by the user, false otherwise.
     */
    public boolean hasBorrowedBook(Book book) {
        for (Book b : borrowedBooks) {               // Iterate over borrowed books
            if (b == book) {                         // Check if the book matches
                return true;                         // Return true if found
            }
        }
        return false;                                // Return false if not found
    }
}
