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

    public static void generateGrades() {
        ArrayList<Integer> assignmentIDs = new ArrayList<>();

        ArrayList<Rosters> rosters = Rosters.getRosters();
        ArrayList<Assignments> assignments = Assignments.getAssignments();

        // Loop through every single student enrollment
        for (Rosters currentStudent : rosters) {
            // For this specific student, scan the ENTIRE assignments list
            for (Assignments currentAssignment : assignments) {
                // Check if the student's offering ID matches the assignment's offering ID
                if (currentStudent.getOfferingID() == currentAssignment.getOfferingID()) {
                    assignmentIDs.add(currentAssignment.getAssignmentID());
                    grades.add(new Grades(currentAssignment.getAssignmentID(), currentStudent.getStudentID()));
                }
            }
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