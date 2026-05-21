import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    private String lastName;
    private String firstName;

    public Students(String fName, String lName){

        this.firstName = fName;
        this.lastName = lName;
    }
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Students");
        ArrayList<Students> listOfStudents = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String first = fileData.get(i).split(" ")[0];
            String last = fileData.get(i).split(" ")[1];
            Students s = new Students(first, last);
            listOfStudents.add(s);
        }
        for (int i = 0; i < listOfStudents.size(); i++) {
            System.out.println(listOfStudents.get(i));
        }
    }

    @Override
    public String toString() {
        return ("INSERT INTO Students (firstName,lastName) " +
                "VALUES (\""+firstName+"\",\""+lastName+"\");");
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
