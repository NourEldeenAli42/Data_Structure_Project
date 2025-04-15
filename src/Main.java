public class Main{
    public static void main(String[] args) {
        Course_List Courses = new Course_List();
        Courses.addCourse(77887,"Calculus");
        Courses.addCourse(77890,"Linear Algebra");
        Courses.addCourse(7791,"Data Structures");

        Student_List Students = new Student_List();

        Students.addStudent(1L,"Nour Eldeen Ali",19,5);
        Students.search (2401244543L).enroll (77887,Courses);
        Students.search (2401244543L).enroll (77890,Courses);
        Students.search (2401244543L).enroll (7791,Courses);

        Students.addStudent(2401248710L,"Mahdy",19,4.0);
        Students.search (2401248710L).enroll (77887,Courses);
        Students.search (2401248710L).enroll (77890,Courses);
        Students.search (2401248710L).enroll (7791,Courses);

        Students.addStudent(2401247684L,"Mr. X",19,4.1);
        Students.search (2401247684L).enroll (77887,Courses);
        Students.search (2401247684L).enroll (77890,Courses);
        Students.search (2401247684L).enroll (7791,Courses);

        Students.addStudent(2401248195L,"Maro",19,4.2);
        Students.search (2401248195L).enroll (77887,Courses);
        Students.search (2401248195L).enroll (77890,Courses);
        Students.search (2401248195L).enroll (7791,Courses);

        Students.addStudent(2401247521L,"Mo'men",19,4.3);
        Students.search (2401247521L).enroll (77887,Courses);
        Students.search (2401247521L).enroll (77890,Courses);
        Students.search (2401247521L).enroll (7791,Courses);

        Students.addStudent(2402402402L,"Mo Waleed",12,5.0);
        Students.search (2401247521L).enroll (77890,Courses);

        Students.search(2401244543L).display_courses();
        Courses.search(7791).display_students();
        Courses.search(77890).display_students();
    }
}