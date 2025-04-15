public class Student_List {
    Linked_Lists hashset = new Linked_Lists();
    public int hashing(long id) {
        return (int)((id * 2654435761L) % 1000); // Knuth's multiplicative hash
    }
    public Student_Node head;
    public Student_Node tail;
    public Student_List() {
        head = null;
        tail = null;
    }
    public void push_front(long el) {
        if (head == null) {
            head = tail = new Student_Node(el);
        } else {
            head.prev= new Student_Node(el);
            head.prev.next = head;
            head = head.prev;
        }
    }
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int counter = 0;
            for (Student_Node node = head; node != null; node = node.next) {
                counter++;

            }
            return counter;
        }
    }
    public void insert_at(int pos,long el) {
        Student_Node temp = this.head;
        for(int i = 0 ; i < pos-1 ; i++){
            temp=temp.next;
        }
        temp.next= new Student_Node(el,temp.next,temp);
    }
    public void insert_at(int pos,long el,String name,int age,double GPA) {
        Student_Node temp = this.head;
        for(int i = 0 ; i < pos-1 ; i++){
            temp=temp.next;
        }
        temp.next= new Student_Node(el,temp.next,temp,name,age,GPA);
    }
    public void addStudent(long ID) {
        int hash = hashing(ID);
        hashset.push_front(hash);
        hashset.sort();
        int pos = hashset.binarySearch(hash);
        if (head == null) {
            head = tail = new Student_Node(ID);
        } else{
            insert_at(pos,ID);
        }
    }
    public void addStudent(long el,String name,int age,double GPA) {
        int hash = hashing(el);
        hashset.push_front(hash);
        hashset.sort();
        int pos = hashset.binarySearch(hash);
        if (head == null) {
            head = tail = new Student_Node(el,name,age,GPA);
        } else {
            insert_at(pos,el,name,age,GPA);
        }
    }
    public void display(){
        System.out.print("[");
        for(Student_Node node = head; node != null; node = node.next) {
            if(node.next == null) {
                System.out.print(node.getFirstName()+hashing(node.getID()));
                break;
            }
            System.out.print(node.getFirstName() +","+hashing(node.getID())+" , ");
        }
        System.out.print("]");
    }
    //To be changed to Binary Search
    public Student_Node search(long el) {
        Student_Node temp = this.head;
        for (int i=0 ; i < size() ; i++) {
            if (temp.getID()==el) {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

}