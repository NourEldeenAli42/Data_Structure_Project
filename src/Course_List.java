@SuppressWarnings("ALL")
public class Course_List {
    Course_Node head;
    Course_Node tail;
    public Course_List(){
        this.head = null;
        this.tail = null;
    }
    public int hashing(long id) {
        return (int)((id * 2654435761L) % 1000); // Knuth's multiplicative hash
    }
    public void push_front(int el) {
        if (head == null) {
            head = tail = new Course_Node(el);
        } else {
            head.prev= new Course_Node(el);
            head.prev.next = head;
            head = head.prev;
        }
    }
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int counter = 0;
            for (Course_Node node = head; node != null; node = node.next) {
                counter++;
            }
            return counter;
        }
    }
    public void insert_at(int pos,int el) {
        Course_Node temp = this.head;
        for(int i = 0 ; i < pos-1 ; i++){
            temp=temp.next;
        }
        temp.next= new Course_Node(el,temp.next,temp);
    }
    public void addCourse(int el) {
        int pos = hashing(el);
        if (head == null) {
            head = tail = new Course_Node(el);
        } else if (pos>this.size()) {
            Course_Node temp = head;
            for (int i = 0; i < this.size(); i++) {
                if (hashing(temp.getID())<pos) {
                    this.insert_at(i+1,el);
                    break;
                } else{
                    push_front(el);
                }
            }
        } else if (pos<1) {
            push_front(el);
        } else {
            Course_Node temp = this.head;
            for (int i = 0; i < pos-1; i++) {
                temp = temp.next;
            }
            temp.next = new Course_Node(el,temp.next,temp);
        }
    }
    public void display(){
        System.out.print("[");
        for(Course_Node node = head; node != null; node = node.next) {
            if(node.next == null) {
                System.out.print(node.getName());
                break;
            }
            System.out.print(node.getName() +" , ");
        }
        System.out.print("]");
    }
    public void change_name(int el,String first_name) {
        Course_Node temp = this.head;
        while (temp != null) {
            if (temp.getID()==el) {
                temp.setName(first_name);
                break;
            }
            temp = temp.next;
        }
    }
    public Course_Node search(long el) {
        Course_Node temp = this.head;
        for (int i=0 ; i < size(); i++) {
            if(temp.getID()==el){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}
