import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CourseOfferings {

    private final int courseID;
    private final int teacherID;
    private final int roomID;
    private final int period;
    private static final ArrayList<CourseOfferings> courseOfferings = new ArrayList<>();

    public CourseOfferings(int courseID, int teacherID, int roomID, int period){
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.roomID = roomID;
        this.period = period;
    }

    public static void main(String[] args) {
        CourseOfferings c = new CourseOfferings(1,1,1,1);
        CourseOfferings c1 = new CourseOfferings(2,2,2,2);
        courseOfferings.add(c);
        courseOfferings.add(c1);
        printCourseOfferings();
    }

    public static void generateCourseOfferings() {

        ArrayList<Courses> courses = Courses.getCourses();
        ArrayList<Teachers> teachers = Teachers.getTeachers();
        ArrayList<Rooms> rooms = Rooms.getRooms();

        ArrayList<CourseOfferings> temp = new ArrayList<>();

        Random rand = new Random();

        for (Courses c : courses) {

            int numOfferings = rand.nextInt(5) + 1;

            for (int i = 0; i < numOfferings; i++) {

                boolean placed = false;

                for (int attempt = 0; attempt < 200 && !placed; attempt++) {

                    int period = rand.nextInt(10) + 1;

                    Teachers t = teachers.get(rand.nextInt(teachers.size()));
                    Rooms r = rooms.get(rand.nextInt(rooms.size()));

                    boolean teacherConflict = false;
                    boolean roomConflict = false;

                    for (CourseOfferings co : temp) {
                        if (co.teacherID == t.getTeacherID() && co.period == period) {
                            teacherConflict = true;
                        }
                        if (co.roomID == r.getRoomID() && co.period == period) {
                            roomConflict = true;
                        }
                    }

                    if (!teacherConflict && !roomConflict) {
                        temp.add(new CourseOfferings(c.getCourseID(), t.getTeacherID(), r.getRoomID(),period));
                        placed = true;
                    }
                }
            }
        }

        courseOfferings.clear();
        courseOfferings.addAll(temp);
    }

    public static void printCourseOfferings(){
        System.out.println("insert into CourseOfferings (courseId, teacherID, roomId, period) values");
        for (int i = 0; i < courseOfferings.size()-1; i++) {
            System.out.print(courseOfferings.get(i));
            System.out.println(",");
        }
        System.out.print(courseOfferings.getLast());
        System.out.println(";");
    }

    public static ArrayList<CourseOfferings> getCourseOfferings() {
        return courseOfferings;
    }

    @Override
    public String toString() {
        return ("("+courseID+","+teacherID+","+roomID+","+period+")");
    }
}
