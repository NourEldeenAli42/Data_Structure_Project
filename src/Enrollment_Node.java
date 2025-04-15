public class Enrollment_Node {
    int Status;
    char grade;
    Enrollment_Node next_student;
    Enrollment_Node next_course;
    public Enrollment_Node(){
        this.Status=0;
        this.grade=' ';
        this.next_student=null;
        this.next_course=null;
    }
}
