public class Main {
    public static void main(String[] args){

        Departments.getDepartments().clear();
        Students.getStudents().clear();
        Rooms.getRooms().clear();
        Teachers.getTeachers().clear();
        Courses.getCourses().clear();
        CourseOfferings.getCourseOfferings().clear();
        Rosters.getRosters().clear();
        Assignments.getAssignments().clear();
        Grades.getGrades().clear();

        Departments.generateDepartments();
        Students.generatesStudents();
        Rooms.generateRooms();
        Teachers.generateTeachers();
        Courses.generateCourses();
        CourseOfferings.generateCourseOfferings();
        Rosters.generateRosters();
        Assignments.generateAssignments();
        Grades.generateGrades();


//        Departments.printDepartments();
//        System.out.println();
//
//        Students.printStudents();
//        System.out.println();

        Rooms.printRooms();
        System.out.println();

//        Teachers.printTeachers();
//        System.out.println();


//        Courses.printCourses();
//        System.out.println();

        CourseOfferings.printCourseOfferings();
        System.out.println();
//
//        Rosters.printRosters();
//        System.out.println();
//
//        Assignments.printAssignments();
//        System.out.println();
//
//        Grades.printGrades();
    }
}
