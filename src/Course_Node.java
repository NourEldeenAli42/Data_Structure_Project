public class Course_Node {
    private long ID;
    private String name;
    public Course_Node next;
    public Course_Node prev;
    public Enrollment_Node first_student;
    public Course_Node(int ID) {
        this.ID = ID;
    }

    public Course_Node(int ID, Course_Node next, Course_Node prev, String name) {
        this.ID = ID;
        this.next = next;
        this.prev = prev;
        this.name = name;
    }

    public Course_Node(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public long getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Course_Node(int ID, Course_Node next, Course_Node prev) {
        this.ID = ID;
        this.next = next;
        this.prev = prev;
    }
    //Put condition to display only active students
    public void display_students() {
        Enrollment_Node temp = first_student;
        System.out.println("Students Enrolled in " + this.name+":");
        while(temp!=null){
            System.out.println(temp.student.getFirstName());
            temp=temp.next_student;
        }
        System.out.println();
    }

}
