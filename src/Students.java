import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    private static final ArrayList<Students> students = new ArrayList<>();
    private final String lastName;
    private final String firstName;

    public Students(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }

    public static void generatesStudents() {
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
        for (int i = 0; i < students.size()-1; i++) {
            System.out.print(students.get(i)); System.out.println(",");
        }
        System.out.print(students.getLast()); System.out.println(";");
    }

    @Override
    public String toString() {
            return ("(\""+firstName+"\",\""+lastName+"\")");
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