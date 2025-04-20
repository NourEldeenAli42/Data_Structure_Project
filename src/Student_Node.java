public class Student_Node {

    //Class Data Fields
    public String name;
    public int age;
    public long ID;
    public double GPA;
    Student_Node next;
    Student_Node prev;
    public Enrollment_Node first_course;
    public Enrollment_Node last_course;

    //Class Constructor
    public Student_Node(long ID, String firstName, int age, double GPA) {
        this.ID = ID;
        name = firstName;
        this.age = age;
        this.GPA = GPA;
    }

    

    //Enrolls the student in a specified course by creating Enrollment_Node
    public void enroll(long id, Course_List course) {
        int var;
        Course_Node req = course.binarySearch (id);
        if (first_course == null) {
            if (req.first_student == null) {
                var = 0;
            } else {
                var = 1;
            }
        } else {
            if (req.first_student == null) {
                var = 2;
            } else
                var = 3;
        }
        switch (var) {
            case 0: {
                Enrollment_Node newNode = new Enrollment_Node ();
                this.first_course = newNode;
                this.last_course = newNode;
                req.first_student = newNode;
                req.last_student = newNode;
                newNode.student = this;
                newNode.course = req;
                break;
            }
            case 1: {
                Enrollment_Node newNode = new Enrollment_Node ();
                this.first_course = newNode;
                this.last_course = newNode;
                req.last_student.next_student = newNode;
                req.last_student=newNode;
                newNode.student=this;
                newNode.course=req;
                break;
            }
            case 2: {
                Enrollment_Node newNode = new Enrollment_Node ();
                req.first_student = newNode;
                req.last_student = newNode;
                this.last_course.next_course = newNode;
                this.last_course=newNode;
                newNode.course = req;
                newNode.student = this;
                break;
            }
            case 3: {
                Enrollment_Node newNode = new Enrollment_Node ();
                req.last_student.next_student = newNode;
                req.last_student=newNode;
                this.last_course.next_course = newNode;
                this.last_course=newNode;
                newNode.student = this;
                newNode.course = req;
                break;
            }
        }

    }


    //Prints all courses that this student is enrolled in
    public void display_courses() {
        Enrollment_Node temp = first_course;
        System.out.println ("Courses that " + this.name + " has enrolled in: ");
        while (temp != null) {
            System.out.println (temp.course.name);
            temp = temp.next_course;
        }
        System.out.println ();
    }                           //Implement:
    //Display_All_Courses  || Display_Active_Courses

    public boolean isNormalStudent()
    {
        int Counter = 0;
        Enrollment_Node temp = first_course;

        while(temp != null){
            Counter++;
            temp = temp.next_course;
        }

        return (Counter >= 2 && Counter <= 7) ? true : false;
    }

}
