/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author batuh
 */
import java.util.Date; // Import Date class to handle transaction dates

// This class represents a transaction in the library
class Transaction {
    // Attributes of a transaction
    private User user;               // The user involved in the transaction
    private Book book;               // The book involved in the transaction
    private String transactionType;  // Type of transaction: "Borrow" or "Return"
    private Date transactionDate;    // Date when the transaction occurred

    // Constructor to initialize a transaction
    public Transaction(User user, Book book, String transactionType) {
        this.user = user;                       // Set the user who performed the transaction
        this.book = book;                       // Set the book involved in the transaction
        this.transactionType = transactionType; // Set the type of transaction ("Borrow" or "Return")
        this.transactionDate = new Date();      // Automatically set the transaction date to the current date
    }

    // Getter method to retrieve the user involved in the transaction
    public User getUser() {
        return user;
    }

    // Getter method to retrieve the book involved in the transaction
    public Book getBook() {
        return book;
    }

    // Getter method to retrieve the type of the transaction
    public String getTransactionType() {
        return transactionType;
    }

    // Getter method to retrieve the date of the transaction
    public Date getTransactionDate() {
        return transactionDate;
    }

    // Overrides the toString method to display transaction details as a string
    @Override
    public String toString() {
        return "Transaction{" +
                "user=" + user.getName() +  // Include the user's name
                ", book=" + book.getTitle() + // Include the book's title
                ", type='" + transactionType + '\'' + // Include the type of transaction
                ", date=" + transactionDate +  // Include the transaction date
                '}';
    }
}