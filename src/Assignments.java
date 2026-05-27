import java.util.ArrayList;

public class Assignments {

    private final int offeringID;
    private final String assignmentName;
    private final boolean isAssignmentMajor;
    private static final ArrayList<Assignments> assignments = new ArrayList<>();

    public Assignments(int offeringID, String assignmentName, boolean isAssignmentMajor){
        this.offeringID = offeringID;
        this.assignmentName = assignmentName;
        this.isAssignmentMajor = isAssignmentMajor;
    }

    public static void generateGrades(){

    }

    public static void main(String[] args) {

    }

    public static ArrayList<Assignments> getAssignments() {
        return assignments;
    }

    public static void printGrades(){
        System.out.println("insert into Assignments (offeringID, assignmentName, isAssignmentMajor) values");
        for (int i = 0; i < assignments.size() - 1; i++) {
            System.out.print(assignments.get(i)); System.out.println(",");
        }
        System.out.print(assignments.getLast()); System.out.println(";");
    }
}
