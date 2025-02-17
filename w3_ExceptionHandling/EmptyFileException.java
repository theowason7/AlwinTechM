package w3_ExceptionHandling;

public class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}
