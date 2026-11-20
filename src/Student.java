import java.util.HashMap;
import java.util.Map;

/**
 * A student with marks per subject. Inherits id and name from Person.
 * Knows how to compute its own CGPA and print its report card.
 */
public class Student extends Person {
    // Collection: subject name -> marks (HashMap keeps lookup by subject easy)
    private final Map<String, Integer> marks = new HashMap<>();

    public Student(String rollNo, String name) {
        super(rollNo, name);
    }

    @Override
    public String fetchRole() {
        return "Student";
    }

    /** Adds or updates marks for a subject; rejects marks outside 0-100. */
    public void recordMarks(String subject, int score) throws InvalidMarksException {
        if (score < 0 || score > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100, got " + score);
        }
        marks.put(subject, score);
    }
}