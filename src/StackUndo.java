class StackUndo{
    StackNode top;
    StackRedo SR;
    public StackUndo(){
        top = null;
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

    }
    public void Undo(Enrollment_Node EN){
        if(top != null){
            Enrollment_Node temp = top.EN;
            top = top.next;
            SR.Push(temp);
        }else{
            System.out.println("Nothing to Undo");
        }
        SR.top = null;
    }

}