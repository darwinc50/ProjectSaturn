import java.util.ArrayList;

public class Rosters {

    private static int rosterID;
    private static int studentID;
    private static int offeringID;
    private static final ArrayList<Rosters> rosters = new ArrayList<>();
    private static int rosterCounter = 1;

    public Rosters(int studentID, int offeringID){
        this.studentID = studentID;
        this.offeringID = offeringID;
        this.rosterID = rosterCounter;
        rosterCounter++;
    }

    public static void generateRosters(){
        ArrayList<CourseOfferings> courseOfferings = CourseOfferings.getCourseOfferings();
        ArrayList<Students> students = Students.getStudents();
    }

    public static ArrayList<Rosters> getRosters() {
        return rosters;
    }

    public static int getRosterID() {
        return rosterID;
    }

    public static void printRosters(){
        System.out.println("insert into rosters (studentID, offeringID) values");
        for (int i = 0; i < rosters.size() - 1; i++) {
            System.out.print(rosters.get(i));
            System.out.println(",");
        }
        System.out.print(rosters.getLast());
        System.out.println(";");
    }

    @Override
    public String toString() {
        return ("("+studentID+","+offeringID+")");
    }
}
