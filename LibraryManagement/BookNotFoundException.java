package LibraryManagement;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class MaxBooksAllowedException extends Exception {
    public MaxBooksAllowedException(String message) {
        super(message);
    }
}
