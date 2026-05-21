import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Departments {
    private String departmentName;

    public Departments(String depName){
        this.departmentName = depName;
    }
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Departments");
        ArrayList<Departments> departments = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            Departments d = new Departments(fileData.get(i));
            departments.add(d);
        }
        for (Departments d : departments){
            System.out.println(d);
        }
    }

    @Override
    public String toString() {
        return ("Insert into Departments (departmentName) " + "VALUES (\""+departmentName+"\");");
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
