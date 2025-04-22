public class Course_Node {

    //Class Data Fields
    public long ID;
    public String name;
    public Course_Node next;
    public Course_Node prev;
    public Enrollment_Node first_student;
    public Enrollment_Node last_student;


    //Class Constructor
    public Course_Node(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }
 
    //Put condition to display only active students
    public void display_students() {
        Student_List temp = new Student_List();
        Enrollment_Node temp1 = first_student;
        while(temp1 != null){
            temp.addStudent(temp1.student.ID,temp1.student.name,temp1.student.age,temp1.student.GPA);
            temp1 = temp1.next_student;
        }
        temp.display();
    }
    
    //Checks if 30 students registered at a specified course;
    public boolean isFullCourse()
    {
        int Counter = 0;
        Enrollment_Node temp = first_student;

        while(temp != null){
            Counter++;
            temp = temp.next_student;
        }

        return Counter == 30;
    }
}
