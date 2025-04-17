public class Course_List {
    Course_Node head;
    Course_Node tail;

    //Constructor of the list
    public Course_List(){
        this.head = null;
        this.tail = null;
    }


    //Returns number of Courses
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

    //Adds new course using ID and Course Name
    public void addCourse(int ID,String name) {
        if (head == null) {
            head = tail = new Course_Node(ID,name);
        } else {
            head.prev= new Course_Node(ID,name);
            head.prev.next = head;
            head = head.prev;
        }
        this.MergeSort ();
    }

    //Prints all Available Courses
    @SuppressWarnings("unused")
    public void display(){
        System.out.print("[");
        for(Course_Node node = head; node != null; node = node.next) {
            if(node.next == null) {
                System.out.print(node.name);
                break;
            }
            System.out.print(node.name +" , ");
        }
        System.out.print("]");
    }



                                            //Searching And Sorting Functions           Done By: Nour "Eldeen" Ali


    //Splits the list into two lists
    static Course_Node split(Course_Node head){
        Course_Node fast = head;
        Course_Node slow = head;
        while (fast != null && fast.next != null
                && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Course_Node temp = slow != null ? slow.next : null;
        if (slow != null) {
            slow.next = null;
        }
        if (temp != null) {
            temp.prev = null;
        }
        return temp;
    }

    //Merge the two sorted lists
    static Course_Node merge(Course_Node first, Course_Node second) {
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


    //The function of Merge sort Done on head Node
    public Course_Node sort(Course_Node head) {
        if (head == null||head.next==null) {
            return head;
        } else{
            Course_Node second = split(head);
            head = sort(head);
            second = sort(second);
            return merge(head, second);
        }
    }


    //Function to be called from list directly
    public void MergeSort(){
        this.head = sort(head);
    }


    //Binary Search
    public Course_Node binarySearch(long target) {
        Course_Node start = head;
        Course_Node end = null;

        do{
            Course_Node middle = getMiddle(start, end);
            if (middle == null) {
                return null;
            }
            if (middle.ID == target) {
                return middle;
            } else if(middle.ID<target) {
                start = middle.next;
            } else {
                end=middle;
            }
        }while (end == null || end.next != start);
        return null;
    }


    //Returns middle Node using Dual Pointers Method
    public Course_Node getMiddle(Course_Node start, Course_Node end) {
        if (start == null) return null;

        Course_Node slow = start;
        Course_Node fast = start;

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
