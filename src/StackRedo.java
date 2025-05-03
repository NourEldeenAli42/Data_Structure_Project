class StackRedo {
    StackNode top;
    StackUndo SU;

    public StackRedo() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void SetUndo(StackUndo SU) {
        this.SU = SU;
    }

    public void Push(Enrollment_Node EN, Enrollment_Node prev_student, Enrollment_Node prev_course) {
        if (top == null) {
            top = new StackNode (EN);
        } else {

            top = new StackNode (EN, top);

        }
        top.prev_student = prev_student;
        top.prev_course = prev_course;
    }

    public void Redo() {
        if (top != null) {
            Enrollment_Node temp = top.EN;
            SU.Push (temp);
            if (temp.student.first_course == null) {
                temp.student.first_course = temp;
                temp.student.first_course.next_course = null;
                temp.student.first_course.prev_course = null;
            } else {
                temp.prev_course = temp.student.last_course;
                temp.student.last_course.next_course = temp;
                temp.student.last_course = temp;
                temp.next_course = null;
            }
            if (temp.course.first_student == null) {
                temp.course.first_student = temp;
                temp.course.first_student.next_student = null;
                temp.course.first_student.prev_student = null;
            } else {
                temp.prev_student = temp.course.last_student;
                temp.course.last_student.next_student = temp;
                temp.course.last_student = temp;
                temp.next_student = null;
            }
            top = top.next;
        } else {
            System.out.println ("Nothing to Redo");
        }
    }
}