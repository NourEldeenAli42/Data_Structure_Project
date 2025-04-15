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
    public void addStudent(long el) {
        int hash = hashing(el);
        hashset.push_front(hash);
        hashset.sort();
        int pos = hashset.binarySearch(hash);
        if (head == null) {
            head = tail = new Student_Node(el);
        } else if (pos>this.size()) {
            Student_Node temp = head;
            for (int i = 0; i < this.size(); i++) {
                if (hashing(temp.getID())>pos) {
                    this.insert_at(i+1,el);
                    break;
                } else{
                    push_front(el);
                    break;
                }
            }
        } else if (pos<1) {
            push_front(el);
        } else {
            Student_Node temp = this.head;
            for (int i = 0; i < pos-1; i++) {
                temp = temp.next;
            }
            temp.next = new Student_Node(el,temp.next,temp);
        }
    }
    public void addStudent(long el,String name,int age,double GPA) {
        int hash = hashing(el);
        hashset.push_front(hash);
        hashset.sort();
        int pos = hashset.binarySearch(hash);
        if (head == null) {
            head = tail = new Student_Node(el,name,age,GPA);
        } else if (pos>this.size()) {
            Student_Node temp = head;
            for (int i = 0; i < this.size(); i++) {
                if (hashing(temp.getID())>pos) {
                    this.insert_at(i+1,el);
                    break;
                } else{
                    push_front(el);
                    break;
                }
            }
        } else if (pos<1) {
            push_front(el);
        } else {
            Student_Node temp = this.head;
            for (int i = 0; i < pos-1; i++) {
                temp = temp.next;
            }
            temp.next = new Student_Node(el,temp.next,temp,name,age,GPA);
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
    public void change_first(long el,String first_name) {
        Student_Node temp = this.head;
        while (temp != null) {
            if (temp.getID()==el) {
                temp.setFirstName(first_name);
                break;
            }
            temp = temp.next;
        }
    }
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