package LibraryManagement;

import java.io.*;
import java.util.Arrays;

public class Main {
	    public static void main(String[] args) {
	        LibraryManager libraryManager = new LibraryManager();

	        // Create and add books to the library
	        Book book1 = new Book("Java Programming", "John Doe", "12345");
	        Book book2 = new Book("Data Structures", "Jane Smith", "67890");
	        libraryManager.addBook(book1);
	        libraryManager.addBook(book2);

	        // Create and add users to the library
	        User user1 = new User("Alice", "U001");
	        User user2 = new User("Bob", "U002");
	        libraryManager.addUser(user1);
	        libraryManager.addUser(user2);

	        // Simulate borrowing and returning books
	        Runnable task1 = () -> {
	            try {
	                libraryManager.borrowBook("12345", "U001");
	                libraryManager.returnBook("12345", "U001");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        };

	        Runnable task2 = () -> {
	            try {
	                libraryManager.borrowBook("67890", "U002");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        };

	        Thread thread1 = new Thread(task1);
	        Thread thread2 = new Thread(task2);
	        thread1.start();
	        thread2.start();

	        try {
	            thread1.join();
	            thread2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Library operations completed.");
	    }
	}
