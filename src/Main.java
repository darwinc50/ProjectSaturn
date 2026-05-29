public class Main {
    public static void main(String[] args){
        Students.generatesStudents();
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        CourseOfferings.generateCourseOfferings();
        Rosters.generateRosters();
        Assignments.generateAssignments();
//        Grades.generateGrades();
//
//
//        Students.printStudents();
//        System.out.println();
//
//        Teachers.printTeachers();
//        System.out.println();
//        Rooms.printRooms();
//        System.out.println();
//
//        Departments.printDepartments();
//        System.out.println();
//
//        Courses.printCourses();
//        System.out.println();
//
//        CourseOfferings.printCourseOfferings();
//        System.out.println();
//
//        Rosters.printRosters();
//        System.out.println();

        Assignments.printGrades();
        System.out.println(Assignments.getAssignments().size());
//        System.out.println();

//        Grades.printGrades();
//        System.out.println(Grades.getGrades().size());
    }
}
