import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grades {

    private final int assignmentID;
    private final int studentID;
    private final int grade;
    private static final ArrayList<Grades> grades = new ArrayList<>();

    public Grades(int aID, int sID){
        this.assignmentID = aID;
        this.studentID = sID;
        this.grade = (int) (Math.random() * 26) + 75;
    }

    public static void generateGrades(){//im so lost
        ArrayList<Integer> assignmentIDs = new ArrayList<>();
        for (int i = 0; i < Rosters.getRosters().size(); i++) {
            assignmentIDs.add(Assignments.getAssignments().get(i).getAssignmentID());
        }
        System.out.println(assignmentIDs.size());
    }

    @Override
    public String toString() {
        return ("("+assignmentID+","+studentID+","+grade+")");
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public static void printGrades(){
        System.out.println("insert into Grades (assignmentID, studentID, grade) values");
        for (int i = 0; i < grades.size() - 1; i++) {
            System.out.print(grades.get(i)); System.out.println(",");
        }
        System.out.print(grades.getLast()); System.out.println(";");
    }

    public static ArrayList<Grades> getGrades() {
        return grades;
    }
}