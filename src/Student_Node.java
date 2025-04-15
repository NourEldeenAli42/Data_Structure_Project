@SuppressWarnings("ALL")
public class Student_Node{
    private String firstName;
    private String lastName;
    private int age;
    private long ID;
    Student_Node next;
    Student_Node prev;
    public Student_Node(long ID, Student_Node next, Student_Node prev, String firstName, int age, double GPA) {
        this.ID = ID;
        this.next = next;
        this.prev = prev;
        this.firstName = firstName;
        this.age = age;
        this.GPA = GPA;
    }
    public Student_Node(long ID, String firstName, int age, double GPA) {
        this.ID = ID;
        this.firstName = firstName;
        this.age = age;
        this.GPA = GPA;
    }
    public double getGPA() {
        return GPA;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private double GPA;
    public Enrollment_Node first_course;
    public Student_Node(long ID) {
        this.ID=ID;
    }
    public Student_Node(long ID,Student_Node next,Student_Node prev) {
        this.ID=ID;
        this.next = next;
        this.prev = prev;
    }
    public void enroll(long id,Course_List course) {
        Course_Node req = course.search(id);
        if(this.first_course == null){
            this.first_course=new Enrollment_Node();
            req.first_student=this.first_course;
            this.first_course.student=this;
            this.first_course.course= req;
        } else{
            Enrollment_Node temp=this.first_course;
            while(temp.next_course != null){
                temp=temp.next_course;
            }
            temp.next_course=new Enrollment_Node();
            temp=temp.next_course;
            if (req.first_student==null){
                req.first_student=temp;
            } else{
            Enrollment_Node temp2=req.first_student;
            while(temp2.next_student!=null){
                temp2=temp2.next_student;
            }
            temp2.next_student=temp;
            }
            temp.student=this;
            temp.course=req;
        }
    }
    public void display_courses(){
        Enrollment_Node temp=first_course;
        System.out.println("Courses that " +this.firstName + " has enrolled in: ");
        while(temp!=null){
            System.out.println(temp.course.getName());
            temp=temp.next_course;
        }
        System.out.println();
    }
}
