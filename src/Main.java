import java.util.List;
import java.util.Scanner;

/** Console menu for the Student Information and Grade Tracker. */
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add student  2. Add marks  3. Report card  4. Rank list  5. Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();

            try {
                if (choice.equals("1")) {
                    System.out.print("Roll no: ");
                    String roll = sc.nextLine().trim();
                    System.out.print("Name: ");
                    manager.registerStudent(roll, sc.nextLine().trim());
                    System.out.println("Student added.");

                } else if (choice.equals("2")) {
                    System.out.print("Roll no: ");
                    Student s = manager.findStudent(sc.nextLine().trim());
                    System.out.print("Subject: ");
                    String subject = sc.nextLine().trim();
                    System.out.print("Marks (0-100): ");
                    s.recordMarks(subject, Integer.parseInt(sc.nextLine().trim()));
                    System.out.println("Marks saved.");

                } else if (choice.equals("3")) {
                    System.out.print("Roll no: ");
                    manager.findStudent(sc.nextLine().trim()).showReportCard();

                } else if (choice.equals("4")) {
                    List<Student> ranked = manager.buildRankList();
                    int rank = 1;
                    for (Student s : ranked) {
                        System.out.printf("%d. %s (%s) - CGPA %.2f%n",
                                rank++, s.fetchName(), s.fetchId(), s.computeCgpa());
                    }

                } else if (choice.equals("5")) {
                    System.out.println("Bye!");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (StudentNotFoundException | InvalidMarksException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a number for marks.");
            }
        }
        sc.close();
    }
}