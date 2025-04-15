
public class Course_List {
    Linked_Lists hashset = new Linked_Lists();
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
    public void insert_at(int pos,int el,String name) {
        Course_Node temp = this.head;
        for(int i = 0 ; i < pos-1 ; i++){
            temp=temp.next;
        }
        temp.next= new Course_Node(el,temp.next,temp,name);
    }
    public void addCourse(int ID) {
        int hash = hashing(ID);
        hashset.push_front(hash);
        hashset.sort();
        int pos = hashset.binarySearch(hash);
        if (head == null) {
            head = tail = new Course_Node(ID);
        } else{
            insert_at(pos,ID);
        }
    }
    public void addCourse(int ID,String name) {
        int hash = hashing(ID);
        hashset.push_front(hash);
        hashset.sort();
        int pos = hashset.binarySearch(hash);
        if (head == null) {
            head = tail = new Course_Node(ID,name);
        } else{
            insert_at(pos,ID,name);
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
    //Binary Search to be implemented
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
