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
            System.out.println ("\nCourses that " + this.name + " has enrolled in : ");
            while (temp != null) {
                System.out.println (temp.course.name);
                temp = temp.next_course;
            }
            System.out.println ();
        }                           //Implement:
    //Display_All_Courses  || Display_Active_Courses
    public void displaySortedCourses() {
        Course_List temp = new Course_List();
        Enrollment_Node temp1 = first_course;
        while(temp1 != null){
            temp.addCourse(temp1.course.ID,temp1.course.name);
            temp1 = temp1.next_course;
        }
        temp.display();
    }

    //Removes specified Enrollment_Node 
    public void removeEnrollment(long id, Course_List course) {
        int var;
        Course_Node req = course.binarySearch (id);
        if (first_course == null) {
                var = 1;
        } else {
            if (req.first_student == null) {
                var = 2;
            } else
                var = 3;
        }
        switch (var) {
           
            case 1: 
            case 2: 
                System.out.println("\nThe student did not register for the course at all.");
                break;
            
            case 3: 
                if(!isRegistered (id, course)){
                    System.out.println("\nThe student did not register for the course at all.");
                } else {

                    if((req.first_student.student.ID == this.ID) && 
                    (this.first_course.course.ID == id))
                    {

                        if(this.first_course.next_course != null){
                            this.first_course= this.first_course.next_course;
                            this.first_course.next_course = null;
                        }
                        else{
                            this.first_course= null;
                        }

                        if(req.first_student.next_student != null){
                            req.first_student = req.first_student.next_student;
                            req.first_student.next_student = null;
                        }
                        else{
                            req.first_student = null;
                        }

                        System.out.println("\nThe course enrollment has been successfully deleted.");


                    }
                    else if(req.first_student.student.ID == this.ID)
                    {
                         if(req.first_student.next_student != null){
                            req.first_student = req.first_student.next_student;
                            req.first_student.next_student = null;
                        }
                        else{
                            req.first_student = null;
                        }

                        Enrollment_Node temp ;
                        Enrollment_Node prev ;

                        prev = this.first_course;
                        temp = this.first_course.next_course;

                        while((temp.course.ID != id)){
                            prev = prev.next_course;
                            temp = temp.next_course;
                        }

                        if(temp.next_course != null){
                            prev.next_course = temp.next_course;
                        }else{

                            prev.next_course = null;
                        }

                        System.out.println("\nThe course enrollment has been successfully deleted.");

                    }
                    else if(this.first_course.course.ID == id)
                    {
                        if(this.first_course.next_course != null){
                            this.first_course= this.first_course.next_course;
                            this.first_course.next_course = null;
                        }
                        else{
                            this.first_course= null;
                        }

                        Enrollment_Node temp ;
                        Enrollment_Node prev ;

                        prev = req.first_student;
                        temp = req.first_student.next_student;

                        while(temp.student.ID != this.ID){
                            prev = prev.next_student;
                            temp = temp.next_student;
                        }

                        if(temp.next_student != null){
                            prev.next_student = temp.next_student;
                        } else {
                            
                            prev.next_student= null;
                        }

                        System.out.println("\nThe course enrollment has been successfully deleted.");

                    }
                    else
                    {
                        Enrollment_Node temp1 ;
                        Enrollment_Node prev1 ;

                        prev1 = this.first_course;
                        temp1 = this.first_course.next_course;

                        while((temp1.course.ID != id)){
                            prev1 = prev1.next_course;
                            temp1 = temp1.next_course;
                        }

                        if(temp1.next_course != null){
                            prev1.next_course = temp1.next_course;
                        }else{

                            prev1.next_course = null;
                        }

                        Enrollment_Node temp2 ;
                        Enrollment_Node prev2 ;

                        prev2 = req.first_student;
                        temp2 = req.first_student.next_student;

                        while(temp2.student.ID != this.ID){
                            prev2 = prev2.next_student;
                            temp2 = temp2.next_student;
                        }

                        if(temp2.next_student != null){
                            prev2.next_student = temp2.next_student;
                        } else {
                            
                            prev2.next_student= null;
                        }

                        System.out.println("\nThe course enrollment has been successfully deleted.");

                    }
                }
                break;
            
        }

    }

    //Checks if a student registered a specified course
    public boolean isRegistered(long id, Course_List course){

        Course_Node node = course.binarySearch(id);
        Enrollment_Node temp;
        temp = node.first_student;

        while(temp != null){

            if(temp.student.ID == this.ID){
                return true;
            }
            temp = temp.next_student;
        }

        return false;
    }

    //Checks if students registered (2:7) courses
    public boolean isNormalStudent(){
        int Counter = 0;
        Enrollment_Node temp = first_course;

        while(temp != null){
            Counter++;
            temp = temp.next_course;
        }

        return Counter >= 2 && Counter <= 7;
    }

    //Checks if a student registered 7 courses
    public boolean isFullOfCourses(){
        int Counter = 0;
        Enrollment_Node temp = first_course;

        while(temp != null){
            Counter++;
            temp = temp.next_course;
        }

        return Counter == 7;
    }

}
