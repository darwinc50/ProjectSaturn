import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teachers {
    private static final ArrayList<Teachers> teachers = new ArrayList<>();
    private final String firstName;
    private final String lastName;
    private final int deptID;
    private final int teacherID;
    private static int idCounter = 1;

    public Teachers (String fName, String lName, int dID){
        this.firstName = fName;
        this.lastName = lName;
        this.deptID = dID;
        this.teacherID = idCounter;
        idCounter++;
    }
    public static void generateTeachers() {
        ArrayList<String> fileData = getFileData("src/Teachers.csv");
        for (String fileDatum : fileData) {
            String[] parts = fileDatum.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            int deptID = Integer.parseInt(parts[2]);
            Teachers t = new Teachers(firstName,lastName,deptID);
            teachers.add(t);
        }
    }
    public static void printTeachers(){
        System.out.println("Insert into teachers (teacherFirstName, teacherLastName, departmentID)");
        for (int i = 0; i < teachers.size()-1; i++) {
            System.out.print(teachers.get(i));
            System.out.println(",");
        }
        System.out.print(teachers.getLast());
        System.out.println(";");
    }

    public static ArrayList<Teachers> getTeachers() {
        return teachers;
    }

    @Override
    public String toString() {
        return ("(\""+firstName+"\",\""+lastName+"\"," +deptID+")");
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

    public int getTeacherID() {
        return teacherID;
    }
}
