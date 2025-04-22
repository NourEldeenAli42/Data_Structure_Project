class StackUndo{
    StackNode top;
    StackRedo SR;

    public StackUndo(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }
    public void SetRedo(StackRedo SR){
        this.SR = SR;
    }

    public void Push(Enrollment_Node EN){
        if(top == null){
            top = new StackNode(EN);
        }else{
            StackNode nNode = new StackNode(EN,top);
            top = nNode;
        }
        SR.top = null;
    }

    public void Undo(){
        if(top != null){
            Enrollment_Node temp = top.EN;
            SR.Push(temp,temp.prev_student, temp.prev_course);
            if(temp.prev_student != null){
                temp.prev_student.next_student = null;
                temp.course.last_student = temp.prev_student;
            }else{
                temp.course.first_student = null;
            }
            if(temp.prev_course != null){
                temp.prev_course.next_course = null;
                temp.student.last_course = temp.prev_course;
            }else{
                temp.student.first_course = null;
            }
            top = top.next;
        }else{
            System.out.println("Nothing to Undo");
        }
    }

    public void display(){
        StackNode temp = top;
        while(temp !=null){
            System.out.println("Student Name: " + temp.EN.student.name + " // Course Name: " + temp.EN.course.name );
            System.out.println("prev "+temp.EN.prev_course+" "+ temp.EN.prev_student);
            System.out.println("next "+temp.EN.next_course+" "+ temp.EN.next_student);
            temp = temp.next;
        }
    }

}