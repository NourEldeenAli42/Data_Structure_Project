@SuppressWarnings("unused")
public class Enrollment_Node {
    int Status;
    char grade;
    Enrollment_Node next_student;
    Enrollment_Node next_course;
    Student_Node student;
    Course_Node course;
    public Enrollment_Node(){
        this.Status=0;
        this.grade=' ';
        this.next_student=null;
        this.next_course=null;
    }
    public Enrollment_Node(Student_Node student, Course_Node course){
        this.Status=0;
        this.grade=' ';
        this.next_student=null;
        this.next_course=null;
        this.student=student;
        this.course=course;
    }
}
