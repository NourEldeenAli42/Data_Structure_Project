public class Main{
    public static void main(String[] args) {
        Course_List Courses = new Course_List();
        Courses.addCourse(100,"Calculus");
        Courses.addCourse(102,"Linear Algebra");
        Courses.addCourse(101,"Data Structures");

        Student_List Students = new Student_List();
        Students.addStudent(2401244543L,"Nour Eldeen Ali",19,3.9);
        Students.binarySearch (2401244543L).enroll (100,Courses);
        Students.binarySearch (2401244543L).enroll (101,Courses);
        Students.binarySearch (2401244543L).enroll (102,Courses);

        Students.addStudent(2401248710L,"Mahdy",19,4.0);
        Students.binarySearch (2401248710L).enroll (100,Courses);
        Students.binarySearch (2401248710L).enroll (101,Courses);
        Students.binarySearch (2401248710L).enroll (102,Courses);

        Students.addStudent(2401247684L,"Mr. X",19,4.1);
        Students.binarySearch (2401247684L).enroll (100,Courses);
        Students.binarySearch (2401247684L).enroll (101,Courses);
        Students.binarySearch (2401247684L).enroll (102,Courses);

        Students.addStudent(2401248195L,"Maro",19,4.2);
        Students.binarySearch (2401248195L).enroll (100,Courses);
        Students.binarySearch (2401248195L).enroll (101,Courses);
        Students.binarySearch (2401248195L).enroll (102,Courses);

        Students.addStudent(2401247521L,"Mo'men",19,4.3);
        Students.binarySearch (2401247521L).enroll (100,Courses);
        Students.binarySearch (2401247521L).enroll (101,Courses);
        Students.binarySearch (2401247521L).enroll (102,Courses);

        Students.addStudent(2402402402L,"Mo Waleed",12,5.0);
        Students.binarySearch (2402402402L).enroll (102,Courses);

        Students.display ();

        Students.MergeSort ();

        Students.display ();

        Students.binarySearch(2401244543L).display_courses();
        Courses.binarySearch(100).display_students();
        Courses.binarySearch(102).display_students();
    }
}