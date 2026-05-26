import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.*;

public class Students {
    private static ArrayList<Students> students = new ArrayList<>();
    private final String lastName;
    private final String firstName;
    private final int studentID;
    private static int studentCounter = 0;
    private final long count = Files.lines(Path.of("src/Students")).count();


    public Students(String fName, String lName) throws IOException {
        this.firstName = fName;
        this.lastName = lName;
        studentCounter++;
        studentID = studentCounter;
    }

    public static void generatesStudents() throws IOException {
        ArrayList<String> fileData = getFileData("src/Students");
        for (String fileDatum : fileData) {
            String first = fileDatum.split(" ")[0];
            String last = fileDatum.split(" ")[1];
            Students s = new Students(first, last);
            students.add(s);
        }
    }
    public static void printStudents(){
        System.out.println("insert into students (firstName, lastName) values ");
        for (Students student : students) {
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        if (studentID == count){
            return ("(\"" + firstName + "\",\"" + lastName + "\");");
        } else {
            return ("(\""+firstName+"\",\""+lastName+"\"),");
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
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
}