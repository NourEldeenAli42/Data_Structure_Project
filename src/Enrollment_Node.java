public class Enrollment_Node {

    //Class Data Fields
    int Status;
    char grade;
    //Related Student and course in the enrollment node
    Student_Node student;
    Course_Node course;

    Enrollment_Node next_student;
    Enrollment_Node next_course;
    Enrollment_Node prev_student;
    Enrollment_Node prev_course;


    //Class Constructor
    public Enrollment_Node(){                   //Status Dictionary to be done
        this.Status=1;                          //1- Active  ----  0-Inactive
        this.grade='O';
        this.next_student=null;
        this.next_course=null;
        this.prev_student=null;
        this.prev_course=null;
    }
}