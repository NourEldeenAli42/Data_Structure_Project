class StackNode{
    StackNode next;
    Enrollment_Node EN;
    //Redo Variables
    Enrollment_Node prev_student;
    Enrollment_Node prev_course;
    public StackNode(Enrollment_Node EN){
        this.EN = EN;
        this.next = null;
    }
    public StackNode(Enrollment_Node EN,StackNode next){
        this.EN = EN;
        this.next = next;
    }
}