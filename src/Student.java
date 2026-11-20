import java.util.HashMap;
import java.util.Map;

public class Student extends Person {

    private final Map<String, Integer> marks = new HashMap<>();

    public Student(String rollNo, String name) {
        super(rollNo, name);
    }

    @Override
    public String fetchRole() {
        return "Student";
    }
}