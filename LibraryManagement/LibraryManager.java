package LibraryManagement;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LibraryManager extends LibrarySystem {
    private static final int MAX_BOOKS = 5;
    private Lock lock = new ReentrantLock();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        lock.lock();
        try {
            User user = findUserByID(userID);
            Book book = findBookByISBN(ISBN);
            if (user.getBorrowedBooks().size() >= MAX_BOOKS) {
                throw new MaxBooksAllowedException("User has reached the maximum book limit.");
            }
            user.borrowBook(book);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        lock.lock();
        try {
            User user = findUserByID(userID);
            Book book = findBookByISBN(ISBN);
            user.returnBook(book);
            System.out.println(user.getName() + " returned " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        // Reservation logic (optional) can be implemented here
    }

    @Override
    public Book searchBook(String title) {
        return books.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .findFirst()
                    .orElse(null);
    }

    private User findUserByID(String userID) throws UserNotFoundException {
        return users.stream()
                    .filter(user -> user.getUserID().equals(userID))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("User not found: " + userID));
    }

    private Book findBookByISBN(String ISBN) throws BookNotFoundException {
        return books.stream()
                    .filter(book -> book.getISBN().equals(ISBN))
                    .findFirst()
                    .orElseThrow(() -> new BookNotFoundException("Book not found: " + ISBN));
    }
}

