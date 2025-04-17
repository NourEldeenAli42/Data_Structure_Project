public class Student_List {
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
    public void push_front(long el,String name,int age,double GPA) {
        if (head == null) {
            head = tail = new Student_Node(el,name,age,GPA);
        } else {
            head.prev= new Student_Node(el,name,age,GPA);
            head.prev.next = head;
            head = head.prev;
        }
    }
    public boolean is_Empty() {
        return head == null;
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
    //Split the list into two halves
    static Student_Node split(Student_Node head){
        Student_Node fast = head;
        Student_Node slow = head;
        while (fast != null && fast.next != null
                && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Student_Node temp = null;
        if (slow != null) {
            temp = slow.next;
        }
        if (slow != null) {
            slow.next = null;
        }
        if (temp != null) {
            temp.prev = null;
        }
        return temp;
    }
    //merge the two sorted lists
    static Student_Node merge(Student_Node first, Student_Node second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        if (first.getID () < second.getID ()) {
            first.next = merge(first.next, second);
            if (first.next != null) {
                first.next.prev = first;
            }
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null) {
                second.next.prev = second;
            }
            second.prev = null;
            return second;
        }
    }

    public Student_Node sort(Student_Node head) {
        if (head == null||head.next==null) {
            return head;
        } else{
            Student_Node second = split(head);
            head = sort(head);
            second = sort(second);
            return merge(head, second);
        }
    }
    public void MergeSort(){
        this.head = sort(head);
    }
    public void addStudent(long ID) {
        if (is_Empty ()){
            push_front(ID);
        } else{
            push_front(ID);
            MergeSort();
        }
    }
    public void addStudent(long ID,String firstName,int age,double GPA) {
        if (is_Empty ()){
            push_front(ID,firstName,age,GPA);
        } else{
            push_front(ID,firstName,age,GPA);
            MergeSort();
        }
    }

    public void display(){
        System.out.print("[");
        for(Student_Node node = head; node != null; node = node.next) {
            if(node.next == null) {
                System.out.print(node.getFirstName());
                break;
            }
            System.out.print(node.getFirstName() +" , ");
        }
        System.out.print("]");
    }
    //To be changed to Binary Search
    public Student_Node binarySearch(long target) {
        Student_Node start = head;
        Student_Node end = null;

        do{
            Student_Node middle = getMiddle(start, end);
            if (middle == null) {
                return null;
            }
            if (middle.getID () == target) {
                return middle;
            } else if(middle.getID ()<target) {
                start = middle.next;
            } else {
                end=middle;
            }
        }while (end == null || end.next != start);
        return null;
    }
    public Student_Node getMiddle(Student_Node start, Student_Node end) {
        if (start == null) return null;

        Student_Node slow = start;
        Student_Node fast = start.next;

        while (fast != end) {
            fast = fast.next;
            if (fast != end) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }

}