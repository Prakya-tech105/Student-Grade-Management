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
    
    // Sorts students from highest CGPA to lowest CGPA.
    /**
     * Returns students ranked by CGPA, highest first.
     * DSA: our own insertion sort (no Collections.sort / streams).
     */
    public List<Student> buildRankList() {
        List<Student> list = new ArrayList<>(students.values());
        for (int i = 1; i < list.size(); i++) {
            Student key = list.get(i);
            int j = i - 1;
            // shift smaller-CGPA students one place to the right
            while (j >= 0 && list.get(j).computeCgpa() < key.computeCgpa()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        return list;
    }
}