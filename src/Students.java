import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    private final String lastName;
    private final String firstName;
    private final int studentID;
    private static int studentCounter = 0;

    public Students(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
        studentCounter++;
        studentID = studentCounter;
    }

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Students");
        ArrayList<Students> listOfStudents = new ArrayList<>();
        System.out.println("insert into students (firstName, lastName) values ");
        for (String fileDatum : fileData) {
            String first = fileDatum.split(" ")[0];
            String last = fileDatum.split(" ")[1];
            Students s = new Students(first, last);
            listOfStudents.add(s);
        }
        for (Students listOfStudent : listOfStudents) {
            System.out.println(listOfStudent);
        }

    }

    @Override
    public String toString() {
        if (studentID == 5000){
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