class StackNode{
    StackNode next;
    Enrollment_Node EN;
    public StackNode(Enrollment_Node EN){
        this.EN = EN;
        this.next = null;
    }
    public StackNode(Enrollment_Node EN,StackNode next){
        this.EN = EN;
        this.next = next;
    }
}