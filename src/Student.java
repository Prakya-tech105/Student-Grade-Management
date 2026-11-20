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

    /** Converts marks (out of 100) to a grade point on a 10 point scale. */
    private int toGradePoint(int score) {
        if (score >= 90) return 10;
        if (score >= 80) return 9;
        if (score >= 70) return 8;
        if (score >= 60) return 7;
        if (score >= 50) return 6;
        if (score >= 40) return 5;
        return 0; // fail
    }

    /** CGPA = average grade point over all subjects (0 if no marks yet). */
    public double computeCgpa() {
        if (marks.isEmpty()) return 0;
        int total = 0;
        for (int score : marks.values()) {
            total += toGradePoint(score);
        }
        return (double) total / marks.size();
    }

    /** Prints the report card to the console. */
    public void showReportCard() {
        System.out.println("\n===== REPORT CARD =====");
        System.out.println("Roll No : " + fetchId());
        System.out.println("Name    : " + fetchName());
        System.out.println("-----------------------");
        for (Map.Entry<String, Integer> e : marks.entrySet()) {
            System.out.printf("%-12s %3d  (GP %d)%n",
                    e.getKey(), e.getValue(), toGradePoint(e.getValue()));
        }
        System.out.println("-----------------------");
        System.out.printf("CGPA    : %.2f%n", computeCgpa());
        System.out.println("=======================");
    }
}