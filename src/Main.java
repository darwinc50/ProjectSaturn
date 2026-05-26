import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Students.generatesStudents();
        Students.printStudents();
        System.out.println();
        Rooms.generateRooms();
        Rooms.printRooms();
        System.out.println();
        Departments.generateDepartments();
        Departments.printDepartments();

        Teachers.printTeachers();
    }
}
