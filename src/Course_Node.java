public class Course_Node {

    //Class Data Fields
    public long ID;
    public String name;
    public Course_Node next;
    public Course_Node prev;
    public Enrollment_Node first_student;


    //Class Constructor
    public Course_Node(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }


    //Put condition to display only active students
    public void display_students() {
        Enrollment_Node temp = first_student;
        System.out.println("Students Enrolled in " + this.name+":");
        while(temp!=null){
            System.out.println(temp.student.name);
            temp=temp.next_student;
        }
        System.out.println();
    }


    public boolean isFullCourse()
    {
        int Counter = 0;
        Enrollment_Node temp = first_student;

        while(temp != null){
            Counter++;
            temp = temp.next_student;
        }

        return (Counter == 30) ? true : false;
    }
}
