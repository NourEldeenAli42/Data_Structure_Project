class StackRedo{
    StackNode top;
    StackUndo SU;
    public StackRedo(){
        top = null;
    }

    public void SetUndo(StackUndo SU){
        this.SU = SU;
    }

    public void Push(Enrollment_Node EN){
        if(top == null){
            top = new StackNode(EN);
        }else{
            StackNode nNode = new StackNode(EN,top);
            top = nNode;
        }
    }
    public void Redo(Enrollment_Node EN){
        if(top != null){
            Enrollment_Node temp = top.EN;
            top = top.next;
            SU.Push(temp);
        }else{
            System.out.println("Nothing to Redo");
        }
    }
    
}