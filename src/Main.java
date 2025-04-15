public class Main{
    public static void main(String[] args) {
        Course_List Courses = new Course_List();
        Courses.addCourse(77887);
        Courses.change_name(77887,"Calculus");
        Courses.addCourse(77890);
        Courses.change_name(77890,"Ds");
        Courses.addCourse(7791);
        Courses.change_name(7791,"Linear");

        Student_List Students = new Student_List();
        Students.addStudent(2401244977L);
        Students.change_first(2401244977L, "Laila Fouad Shawky");
        Students.addStudent(2401244978L);
        Students.change_first(2401244978L, "Maro Ahmed Hassan");
        Students.addStudent(2401244979L);
        Students.change_first(2401244979L, "Ali Ahmed Fathy");
        Students.search(2401244977L).enroll(7791,Courses);
        System.out.println(Courses.search(7791).first_student);
        System.out.println(Students.search(2401244977L).first_course);
    }
}