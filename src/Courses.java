import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {
    private final String courseName;
    private final String courseType;
    private final int deptID;
    private final int courseID;
    private static int courseCounter = 1;
    private static final ArrayList<Courses> courses = new ArrayList<>();

    public Courses(String name, String type, int ID){
        this.courseName = name;
        this.courseType = type;
        this.deptID = ID;
        this.courseID = courseCounter;
        courseCounter++;
    }

    public static void generateCourses() {
        ArrayList<String> fileData = getFileData("src/Courses.csv");
        for (String fileDatum : fileData) {
            String[] parts = fileDatum.split(",");
            String courseName = parts[0];
            String courseType = parts[1];
            int deptID = Integer.parseInt(parts[2]);
            Courses c = new Courses(courseName,courseType,deptID);
            courses.add(c);
        }
    }

    public static void printCourses() {
        System.out.println("insert into Courses (courseName, courseType, departmentID) values");
        for (int i = 0; i < courses.size() - 1; i++) {
            System.out.print(courses.get(i));
            System.out.println(",");
        }
        System.out.print(courses.get(courses.size() - 1));
        System.out.println(";");
    }

    public static ArrayList<Courses> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
       return ("(\""+courseName+"\",\""+courseType+"\"," +deptID+")");
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public int getCourseID() {
        return courseID;
    }
}
