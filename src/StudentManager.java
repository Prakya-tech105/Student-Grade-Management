import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Stores all students and provides search and ranking features. */
public class StudentManager {
    // Collection: roll number -> Student for fast lookup
    private final Map<String, Student> students = new HashMap<>();

    public void registerStudent(String rollNo, String name) {
        students.put(rollNo, new Student(rollNo, name));
    }

    /** Finds a student by roll number or throws StudentNotFoundException. */
    public Student findStudent(String rollNo) throws StudentNotFoundException {
        Student s = students.get(rollNo);
        if (s == null) {
            throw new StudentNotFoundException("No student with roll number " + rollNo);
        }
        return s;
    }
}