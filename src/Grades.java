import java.util.ArrayList;

public class Grades {

    private final int assignmentID;
    private final int studentID;
    private final int grade;
    private static final ArrayList<Grades> grades = new ArrayList<>();

    public Grades(int aID, int sID){
        this.assignmentID = aID;
        this.studentID = sID;
        this.grade = (int) (Math.random() * 26) + 75;
    }

    public static void main(String[] args) {

    }

    public static void generateGrades(){

    }

    public static void printGrades(){
        System.out.println("insert into Grades (assignmentID, studentID, grade) values");
        for (int i = 0; i < grades.size() - 1; i++) {
            System.out.print(grades.get(i)); System.out.println(",");
        }
        System.out.print(grades.getLast()); System.out.println(";");
    }
}
