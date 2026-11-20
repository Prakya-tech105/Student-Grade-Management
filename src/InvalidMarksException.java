/** Thrown when marks are outside the valid range 0-100. */
public class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}