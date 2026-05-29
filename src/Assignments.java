import java.util.ArrayList;

public class Assignments {

    private final int offeringID;
    private final String assignmentName;
    private final int isAssignmentMajor;
    private static final ArrayList<Assignments> assignments = new ArrayList<>();
    private final int AssignmentID;
    private static int assignmentCounter = 1;

    public Assignments(int offeringID, String assignmentName, int isAssignmentMajor){
        this.offeringID = offeringID;
        this.assignmentName = assignmentName;
        this.isAssignmentMajor = isAssignmentMajor;
        this.AssignmentID = assignmentCounter;
        assignmentCounter++;
    }

    public static void generateAssignments(){
        String name = "Assignment ";
        ArrayList<CourseOfferings> offerings = CourseOfferings.getCourseOfferings();
        for (int i = 0; i < offerings.size(); i++) {
            for (int j = 1; j <= 13; j++) {
                assignments.add(new Assignments(offerings.get(i).getCourseOfferingID(), name + j, 0));
            }
            for (int j = 14; j <= 15; j++) {
                assignments.add(new Assignments(offerings.get(i).getCourseOfferingID(),name + j, 1));
            }
        }
    }

    public int getAssignmentID() {
        return AssignmentID;
    }

    public static ArrayList<Assignments> getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        return ("("+offeringID+",\""+assignmentName+"\"," +isAssignmentMajor+")");
    }

    public int getOfferingID() {
        return offeringID;
    }

    public static void printGrades(){
        System.out.println("insert into Assignments (offeringID, assignmentName, isAssignmentMajor) values");
        for (int i = 0; i < assignments.size() - 1; i++) {
            System.out.print(assignments.get(i)); System.out.println(",");
        }
        System.out.print(assignments.getLast()); System.out.println(";");
    }
}
