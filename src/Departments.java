import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Departments {
    private String departmentName;
    private static ArrayList<Departments> departments = new ArrayList<>();

    public Departments(String depName){
        this.departmentName = depName;
    }

    public static void generateDepartments() {
        ArrayList<String> fileData = getFileData("src/Departments");
        for (String fileDatum : fileData) {
            Departments d = new Departments(fileDatum);
            departments.add(d);
        }
    }
    public static void printDepartments(){
        System.out.println("Insert into Departments (departmentName) values");
        for (int i = 0; i < departments.size() - 1; i++) {
            System.out.print(departments.get(i));
            System.out.println(",");
        }
        System.out.print(departments.getLast());
        System.out.println(";");
    }

    @Override
    public String toString() {
        return ("(\""+departmentName+"\")");
    }

    public static ArrayList<Departments> getDepartments() {
        return departments;
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
