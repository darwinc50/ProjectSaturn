public class Main {
    public static void main(String[] args){

        Students.getStudents().clear();;
        Rooms.getRooms().clear();
        Departments.getDepartments().clear();
        Teachers.getTeachers().clear();
        Courses.getCourses().clear();
        CourseOfferings.getCourseOfferings().clear();
        Rosters.getRosters().clear();
        Assignments.getAssignments().clear();
        Grades.getGrades().clear();

        Students.generatesStudents();
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        CourseOfferings.generateCourseOfferings();
        Rosters.generateRosters();
        Assignments.generateAssignments();
        Grades.generateGrades();


        Students.printStudents();
        System.out.println();
        Teachers.printTeachers();
        System.out.println();
        Rooms.printRooms();
        System.out.println();

        Departments.printDepartments();
        System.out.println();

        Courses.printCourses();
        System.out.println();

        CourseOfferings.printCourseOfferings();
        System.out.println();

        Rosters.printRosters();
        System.out.println();

        Assignments.printGrades();
        System.out.println();

        Grades.printGrades();
    }
}
