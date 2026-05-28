import java.util.ArrayList;

public class Grades {

    private final int assignmentID;
    private final int studentID;
    private final int grade;
    private static final ArrayList<Grades> grades = new ArrayList<>();

    public Grades(int aID, int sID, int g){
        this.assignmentID = aID;
        this.studentID = sID;
        this.grade = g;
    }

    public static void generateGrades(){
        ArrayList<Assignments> assignments = Assignments.getAssignments();
        ArrayList<Students> students = Students.getStudents();
        for (int i = 0; i < assignments.size(); i++) {
            //grades (int) (Math.random() * 26) + 75;
            assignments.get(i).getOfferingID();
        }
    }

    @Override
    public String toString() {
        return ("("+assignmentID+","+studentID+","+grade+")");
    }

    public static void printGrades(){
        System.out.println("insert into Grades (assignmentID, studentID, grade) values");
        for (int i = 0; i < grades.size() - 1; i++) {
            System.out.print(grades.get(i)); System.out.println(",");
        }
        System.out.print(grades.getLast()); System.out.println(";");
    }
}
