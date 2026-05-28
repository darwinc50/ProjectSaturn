import java.util.ArrayList;
import java.util.Random;

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
        ArrayList<CourseOfferings> offerings = CourseOfferings.getCourseOfferings();
        ArrayList<Students> students = Students.getStudents();
        Random rand = new Random();
        for (Students s : students) {
            for (int period = 1; period <= 10; period++) {
                ArrayList<CourseOfferings> valid = new ArrayList<>();
                for (CourseOfferings co : offerings) {
                    if (co.getPeriod() == period) {
                        valid.add(co);
                    }
                }
                if (!valid.isEmpty()) {
                    CourseOfferings chosen = valid.get(rand.nextInt(valid.size()));
                    rosters.add(new Rosters(s.getStudentID(), chosen.getCourseOfferingID()));
                }
            }
        }
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
