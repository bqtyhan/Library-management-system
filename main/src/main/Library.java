/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author batuh
 */

// The Library class manages the books, users, and transactions in the library.
class Library {
    // Constants and variables
    private static final int SHELF_CAPACITY = 10;     // Maximum number of books per shelf
    private Book[][] shelves;                         // 2D array to store books on shelves
    private int shelfCount;                           // Number of shelves
    private User[] users;                             // Array to store registered users
    private int userCount;                            // Number of registered users
    private static int totalRegisteredUsers = 0;      // Static counter for all users ever registered
    private Transaction[] transactions = new Transaction[100]; // Array to store transactions (maximum 100)
    private int transactionCount = 0;                 // Number of recorded transactions

    // Constructor to initialize the library
    public Library() {
        this.shelves = new Book[10][SHELF_CAPACITY];  // Create 10 shelves with defined capacity
        this.shelfCount = 0;                          // Initialize shelf count
        this.users = new User[100];                   // Allow up to 100 users
        this.userCount = 0;                           // Initialize user count
    }

    /**
     * Adds a book to the library.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param totalCopies Total copies of the book to add.
     */
    public void addBook(String title, String author, int totalCopies) {
        for (int i = 0; i < shelves.length; i++) {    // Loop through shelves
            for (int j = 0; j < shelves[i].length; j++) { // Loop through slots on a shelf
                if (shelves[i][j] == null) {          // If an empty slot is found
                    shelves[i][j] = new Book(title, author, totalCopies); // Add the book
                    System.out.println("Book '" + title + "' by '" + author + "' added successfully.");
                    return;
                }
            }
        }
        System.out.println("No space available to add the book."); // If no space is available
    }

    /**
     * Finds a book by its title and author.
     * @param title The title of the book.
     * @param author The author of the book.
     * @return The Book object if found, otherwise null.
     */
    public Book findBookByTitleAndAuthor(String title, String author) {
        for (int i = 0; i < shelves.length; i++) {    // Loop through shelves
            for (int j = 0; j < shelves[i].length; j++) {
                if (shelves[i][j] != null &&
                    shelves[i][j].getTitle().equalsIgnoreCase(title) &&
                    shelves[i][j].getAuthor().equalsIgnoreCase(author)) {
                    return shelves[i][j];            // Return the book if found
                }
            }
        }
        return null;                                 // Return null if not found
    }

    /**
     * Registers a new user.
     * @param name The name of the user.
     * @param email The email of the user.
     */
    public void registerUser(String name, String email) {
        for (int i = 0; i < userCount; i++) {        // Check if the email is already registered
            if (users[i].getEmail().equals(email)) {
                System.out.println("User with this email already exists.");
                return;
            }
        }
        users[userCount++] = new User(name, email);  // Register the new user
        totalRegisteredUsers++;                      // Increment the static counter
        System.out.println("User registered successfully.");
    }

    /**
     * Finds a user by their email.
     * @param email The email of the user.
     * @return The User object if found, otherwise null.
     */
    public User findUserByEmail(String email) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getEmail().equalsIgnoreCase(email)) {
                return users[i];                     // Return the user if found
            }
        }
        return null;                                 // Return null if not found
    }

    /**
     * Allows a user to borrow a book.
     * @param email The email of the user.
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public void borrowBook(String email, String title, String author) {
        Book book = findBookByTitleAndAuthor(title, author); // Find the book
        if (book == null) {
            System.out.println("The book '" + title + "' by '" + author + "' does not exist in the library.");
            return;
        }

        User user = findUserByEmail(email);          // Find the user
        if (user == null) {
            System.out.println("No user found with the email: " + email);
            return;
        }

        // Check if the user has already borrowed this book
        if (user.hasBorrowedBook(book)) {
            System.out.println("User already borrowed this book.");
            return;
        }

        // Borrow the book if available and within limit
        if (book.getAvailableCopies() > 0 && user.borrowBook(book)) {
            book.borrowCopy();                       // Decrement available copies
            transactions[transactionCount++] = new Transaction(user, book, "Borrow"); // Record transaction
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book could not be borrowed. Either no copies are available or the user reached the borrowing limit.");
        }
    }

    /**
     * Allows a user to return a book.
     * @param email The email of the user.
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public void returnBook(String email, String title, String author) {
        Book book = findBookByTitleAndAuthor(title, author); // Find the book
        if (book == null) {
            System.out.println("The book '" + title + "' by '" + author + "' does not exist in the library.");
            return;
        }

        User user = findUserByEmail(email);          // Find the user
        if (user == null) {
            System.out.println("No user found with the email: " + email);
            return;
        }

        // Return the book if the user has borrowed it
        if (user.returnBook(book)) {
            book.returnCopy();                       // Increment available copies
            transactions[transactionCount++] = new Transaction(user, book, "Return"); // Record transaction
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This user has not borrowed the book '" + title + "' by '" + author + "'.");
        }
    }

    /**
     * Displays the list of all transactions.
     */
    public void displayTransactions() {
        if (transactionCount == 0) {
            System.out.println("No transactions to display.");
            return;
        }
        System.out.println("List of Transactions:");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);     // toString method in Transaction handles formatting
        }
    }

    /**
     * Displays all the books in the library.
     */
    public void displayBooks() {
        for (int i = 0; i < shelves.length; i++) {   // Loop through shelves
            for (int j = 0; j < shelves[i].length; j++) {
                if (shelves[i][j] != null) {
                    Book book = shelves[i][j];
                    System.out.println("Title: " + book.getTitle() +
                            ", Author: " + book.getAuthor() +
                            ", Available Copies: " + book.getAvailableCopies() +
                            ", Total Copies: " + book.getTotalCopies());
                }
            }
        }
    }
}
