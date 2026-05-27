public class Main {
    public static void main(String[] args){
        Students.generatesStudents();
        Rooms.generateRooms();
        Departments.generateDepartments();
        Teachers.generateTeachers();
        Courses.generateCourses();
        CourseOfferings.generateCourseOfferings();
//               Rosters.generateRosters();
//        Assignments.generateGrades();
//        Grades.generateGrades();


        Students.printStudents();
        Teachers.printTeachers();
        Rooms.printRooms();
        Departments.printDepartments();
        Courses.printCourses();
        CourseOfferings.printCourseOfferings();
//        Rosters.printRosters();
//        Assignments.printGrades();
//        Grades.printGrades();
    }
}
