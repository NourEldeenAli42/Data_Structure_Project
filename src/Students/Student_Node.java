package Students;

public class Student_Node{
    private String firstName;
    private String lastName;
    private int age;
    private long ID;

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
    Student_Node next;
    Student_Node prev;
    public Student_Node(long ID) {
        this.ID=ID;
    }
    public Student_Node(long ID,Student_Node next,Student_Node prev) {
        this.ID=ID;
        this.next = next;
        this.prev = prev;
    }
}
