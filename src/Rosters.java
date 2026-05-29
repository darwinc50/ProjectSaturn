import java.util.ArrayList;
import java.util.Random;

public class Rosters {

    private final int rosterID;
    private final int studentID;
    private final int offeringID;
    private static final ArrayList<Rosters> rosters = new ArrayList<>();
    private static int rosterCounter = 1;

    public Rosters(int studentID, int offeringID){
        this.studentID = studentID;
        this.offeringID = offeringID;
        this.rosterID = rosterCounter;
        rosterCounter++;
    }

    public static void generateRosters() {
        ArrayList<CourseOfferings> offerings = CourseOfferings.getCourseOfferings();
        ArrayList<Students> students = Students.getStudents();
        Random rand = new Random();
        for (Students s : students) {
            ArrayList<Integer> usedOfferings = new ArrayList<>();
            for (int period = 1; period <= 10; period++) {
                ArrayList<CourseOfferings> candidates = new ArrayList<>();
                for (CourseOfferings co : offerings) {
                    if (co.getPeriod() == period &&
                            !usedOfferings.contains(co.getCourseOfferingID())) {
                        candidates.add(co);
                    }
                }
                if (!candidates.isEmpty()) {
                    CourseOfferings chosen =
                            candidates.get(rand.nextInt(candidates.size()));
                    rosters.add(new Rosters(s.getStudentID(), chosen.getCourseOfferingID()));
                    usedOfferings.add(chosen.getCourseOfferingID());
                }
            }
        }
    }

    public int getStudentID() {
        return studentID;
    }

    public static ArrayList<Rosters> getRosters() {
        return rosters;
    }

    public int getRosterID() {
        return rosterID;
    }

    public int getOfferingID() {
        return offeringID;
    }

    public static void printRosters(){
        System.out.println("insert into Rosters (studentID, offeringID) values");
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
