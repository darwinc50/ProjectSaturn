import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {
    private String name;
    private String type;
    public Courses(String courseName, String courseType){
        this.name = courseName;
        this.type = courseType;
    }
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("");
        ArrayList<Courses> courses = new ArrayList<>();
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
}
