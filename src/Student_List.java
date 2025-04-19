public class Student_List {
    //Class Parameters
    public Student_Node head;
    public Student_Node tail;
    int size;


    //Class Constructor
    public Student_List() {
        head = null;
        tail = null;
    }


    //Checks if the Students list is Empty
    public boolean is_Empty() {
        return head == null;
    }

    //Adds new student to the Students List
    public void addStudent(long ID,String firstName,int age,double GPA) {             // GPA will be used to be calculated depending on Student grade in each course
        if (is_Empty ()){
            head = tail = new Student_Node(ID,firstName,age,GPA);
        } else{
            head.prev= new Student_Node(ID,firstName,age,GPA);
            head.prev.next = head;
            head = head.prev;
            MergeSort();
        }
        size++;
    }

    public boolean isExist(long ID){
        Student_Node temp = head;
        while(temp != null)
        {
            if(temp.ID == ID)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }



    //Prints all students names in console
    public void display(){
        System.out.print("[");
        for(Student_Node node = head; node != null; node = node.next) {
            if(node.next == null) {
                System.out.print(node.name);
                break;
            }
            System.out.print(node.name +" , ");
        }
        System.out.print("]");
    }



                    //Searching & Sorting Functions                 Done By: Nour "Eldeen" Ali

//--------------------------------------Merge Sorting-------------------------------------------//
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
        if (first.ID < second.ID) {
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

    //Sorts the linked list using Merge Sort Algorithm

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


    //Used to call the sort function directrly from list variable
    public void MergeSort(){
        this.head = sort(head);
    }

//--------------------------------------Done By: Nour "Eldeen" Ali--------------------------------//

    //Related to binary search function "returns middle node between two nodes -start,end-"
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


    //Uses Binary search Algorithm implemented by -Dual Pointer- Method
    public Student_Node binarySearch(long target) {
        Student_Node start = head;
        Student_Node end = null;

        do{
            Student_Node middle = getMiddle(start, end);
            if (middle == null) {
                return null;
            }
            if (middle.ID == target) {
                return middle;
            } else if(middle.ID < target) {
                start = middle.next;
            } else {
                end=middle;
            }
        }while (end == null || end.next != start);
        return null;
    }
}