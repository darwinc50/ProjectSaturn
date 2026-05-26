import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teachers {
    private String firstName;
    private String lastName;
    private int deptID;
    private static ArrayList<Teachers> teachers = new ArrayList<>();

    public Teachers (String fName, String lName, int dID){
        this.firstName = fName;
        this.lastName = lName;
        this.deptID = dID;
    }
    public static void generateTeachers() {
        ArrayList<String> fileData = getFileData("src/Teachers");
    }
    public static void printTeachers(){

    }

    @Override
    public String toString() {
        return "";
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
