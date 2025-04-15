@SuppressWarnings("ALL")
public class Linked_Lists {
    public DNode head;
    public DNode tail;
    public Linked_Lists() {
        head = null;
        tail = null;
    }
    public void push_front(int el) {
        if (head == null) {
            head = tail = new DNode(el);
        } else {
            head.prev= new DNode(el);
            head.prev.next = head;
            head = head.prev;
        }
    }
    public void push_back(int el) {
        if (tail == null) {
            head = tail = new DNode(el);
        } else {
            tail.next = new DNode(el);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int counter = 0;
            for (DNode node = head; node != null; node = node.next) {
                counter++;
            }
            return counter;
        }
    }
    public void insert_at(int el,int pos) {
        if (pos>this.size()) {
            push_back(el);
        } else if (pos<1) {
            push_front(el);
        } else {
            DNode temp = this.head;
            for (int i = 0; i < pos-1; i++) {
                temp = temp.next;
            }
            temp.next = new DNode(el,temp.next,temp);
        }
    }
    public Object pop_front() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            Object el = head.info;
            head = tail = null;
            return el;
        } else {
            Object el = head.info;
            head = head.next;
            head.prev = null;
            return el;
        }
    }
    public Object pop_back() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            Object el = head.info;
            head = tail = null;
            return el;
        } else {
            Object el = tail.info;
            tail = tail.prev;
            tail.next = null;
            return el;
        }
    }
    public Object delete_at(int pos) {
        if (pos > this.size()) {
            return pop_back();
        } else if (pos < 1) {
            return pop_front();
        } else {
            DNode temp = this.head;
            for (int i = 0; i < pos-1; i++) {
                temp = temp.next;
            }
            Object el = temp.next.info;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            return el;
        }
    }
    public void sort() {
        DNode current, index;
        int temp;
        //Check whether list is empty
        //noinspection StatementWithEmptyBody
        if(head == null) {
        }
        else {
            //Current will point to head
            for(current = head; current.next != null; current = current.next) {
                //Index will point to node next to current
                for(index = current.next; index != null; index = index.next) {
                    //If current's data is greater than index's data, swap the data of current and index
                    if(current.info > index.info) {
                        temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    }
                }
            }
        }

}
    public void display() {
        if (head == null) {
            System.out.print("List is empty");
        }
        else {
            DNode temp = head;
            while (temp != null) {
                System.out.print(temp.info+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public int binarySearch(int target) {
        DNode start = head;
        DNode end = null;

        while (start != end && (end == null || end.next != start)) {
            DNode mid = getMiddle(start, end);

            if (mid == null) return -1;

            if (mid.info == target) {
                return getIndex(mid); // return the position of the node
            } else if (mid.info < target) {
                start = mid.next;
            } else {
                end = mid.prev;
            }
        }

        return -1; // Not found
    }

    // Find middle node between start and end (inclusive)
    private DNode getMiddle(DNode start, DNode end) {
        if (start == null) return null;

        DNode slow = start;
        DNode fast = start;

        while (fast != end && fast.next != end) {
            fast = fast.next;
            if (fast != end && fast.next != end) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }

    // Get index of a given node in the list
    private int getIndex(DNode node) {
        int index = 0;
        DNode current = head;

        while (current != null) {
            if (current == node) return index;
            current = current.next;
            index++;
        }

        return -1; // Should never happen if node is in the list
    }

}
class DNode {
    public DNode next;
    public DNode prev;
    public int info;

    public DNode(int info, DNode next, DNode prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public DNode(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;
        }
}