public class Student_Node{

    //Class Data Fields
    public String name;
    public int age;
    public long ID;
    public double GPA;
    Student_Node next;
    Student_Node prev;
    public Enrollment_Node first_course;

    //Class Constructor
    public Student_Node(long ID, String firstName, int age, double GPA) {
        this.ID = ID;
        name = firstName;
        this.age = age;
        this.GPA = GPA;
    }



    //Enrolls the student in a specified course by creating Enrollment_Node
    public void enroll(long id,Course_List course) {
        Course_Node req = course.binarySearch(id);
        if(this.first_course == null&&req.first_student==null){
            Enrollment_Node newNode = new Enrollment_Node ();
                this.first_course=newNode;
                req.first_student=newNode;
                newNode.student=this;
                newNode.course=req;
        }
        else if(this.first_course == null) {
            Enrollment_Node newNode = new Enrollment_Node();
            Enrollment_Node temp = req.first_student;
            while(temp.next_student!=null){
                temp = temp.next_student;
            }
            temp.next_student=newNode;
            newNode.student=this;
            newNode.course=req;
        }
        else{
            Enrollment_Node temp=this.first_course;
            while(temp.next_course != null){
                temp=temp.next_course;
            }
            Enrollment_Node newNode = new Enrollment_Node();
            Enrollment_Node temp2 = req.first_student;
            while(temp2.next_student!=null){
                temp2=temp2.next_student;
            }
            temp2.next_student=newNode;
            newNode.student=this;
            newNode.course=req;
        }
    }



    //Prints all courses that this student is enrolled in
    public void display_courses(){
        Enrollment_Node temp=first_course;
        System.out.println("Courses that " +this.name + " has enrolled in: ");
        while(temp!=null){
            System.out.println(temp.course.name);
            temp=temp.next_course;
        }
        System.out.println();
    }                           //Implement:
                                                                //Display_All_Courses  || Display_Active_Courses
}
