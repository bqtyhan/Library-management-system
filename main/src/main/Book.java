/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author batuh
 */

// This class represents a book in the library
public class Book {
    // Attributes of the book: title, author, total copies, and available copies
    private String title,author;
    private int totalCopies,availableCopies;      // Total number of copies of the book in the library and Number of copies currently available for borrowing
     

    // Constructor to initialize a new book with its title, author, and total copies
    public Book(String title, String author, int totalCopies) {
        this.title = title;                     // Set the book's title
        this.author = author;                   // Set the book's author
        this.totalCopies = totalCopies;         // Set the total number of copies
        this.availableCopies = totalCopies;     // Initially, all copies are available
    }

    // Getter method to retrieve the title of the book
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the author of the book
    public String getAuthor() {
        return author;
    }

    // Getter method to retrieve the number of available copies
    public int getAvailableCopies() {
        return availableCopies;
    }

    // Getter method to retrieve the total number of copies
    public int getTotalCopies() {
        return totalCopies;
    }

    // Method to borrow a copy of the book
    // Reduces the available copies by 1 if at least one copy is available
    public void borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    // Method to return a copy of the book
    // Increases the available copies by 1 if the total limit is not exceeded
    public void returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }
}