package Students;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marwan Ehab
 */
class SLL{
    class Node{
        int ID;
        private Node next;
        private static int ArrSize;
        private int Counter;
        
        public Node(){
            ID = 0;
            next = null;
        }
        public Node(int ID){
            this.ArrSize=ArrSize;
            this.ID = ID;
            next = null;
        }
        public Node(int ID,Node n){
            this.ArrSize=ArrSize;
            this.ID = ID;
            this.next = n;
        }
        Node[] MyEnrollees = new Node[ArrSize];
    }
    private Node head;
    private Node tail;
    private int ArrSize;
    SLL(int ArrSize){
        this.ArrSize = ArrSize;
        Node.ArrSize = ArrSize;
        tail = head = null;
    }
    
    public boolean isEmpty(){
        return head == null && tail == null;
    }
    public void AddToHead(int ID){
        if(isEmpty()){
            head = tail = new Node(ID);
        }else{head = new Node(ID,head);}
    }
    public void AddToTail(int ID){
        if(isEmpty()){
            head = tail = new Node(ID);
        }else{tail.next = new Node(ID);tail=tail.next;}
    }
    public int DeleteFromHead(){
        int temp = head.ID;
        head = head.next;
        return temp;
    }
    public int DeleteFromTail(){
        int temp = tail.ID;
        if(isEmpty()){
            System.out.println("The list is Empty!");
            return 0;
        }else if(head==tail){
            head=tail=null;
            return temp;
        }else{
            Node T = head;
            while(T.next.next!=null){
                T = T.next;
            }
            tail = T;
            tail.next = null;
            return temp;
        }
    }
    public int DeleteNode(int ID){
        if(isEmpty()){
            System.out.println("This list is Empty!");
            return 0;
        }else if((head==tail)&&(head.ID==ID)){
            head=tail=null;
            return ID;
        }else if(head.ID==ID){
            head = head.next;
            return ID;
        }else{
            Node temp=head.next;
            Node pre=head;
            while(temp!=null){
                if(temp.ID == ID){
                    pre.next=temp.next;
                    if(temp==tail){
                        tail = pre;
                    }
                    return ID;
                }
            }
            System.out.println("This element hasn't been found!");
            return -1;
        }
    }
    public boolean IsInList(int ID){
        if(isEmpty()){
            System.out.println("This list is Empty!");
            return false;
        }else{
            for(Node temp=head;temp!=null;temp=temp.next){
                if(temp.ID==ID){
                    return true;
                }
            }
            return false;
        }
    }
    public Node GetNode(int ID){
        if(isEmpty()){
            System.out.println("This list is Empty!");
            return null;
        }else{
            for(Node temp=head;temp!=null;temp=temp.next){
                if(temp.ID==ID){
                    return temp;
                }
            }
            return null;
        }
    }
    public void PrintList(){
        System.out.print("This list contains: ");
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.ID+" ");
        }
        System.out.println();
    }
    public void Enroll(int choice,int course,int student){
        if(choice==1){
            GetNode(course).MyEnrollees[0]=GetNode(student);
        }else{
            GetNode(student).MyEnrollees[0]=GetNode(course);
        }
    }
    public void PrintEnrolled(int choice,int course,int student){
        if(choice==1){
            System.out.println(GetNode(course).MyEnrollees[0].ID);
        }else{
            System.out.println(GetNode(student).MyEnrollees[0].ID);
        }
    }
}

class Course{
    private int ID;
    Course next;
    //Student[] MyStudents = new Student[30];
}

public class Project {
    public static void main(String[]args){
        SLL Student = new SLL(7);
        Student.AddToHead(5);
        Student.AddToHead(6);
        Student.AddToHead(8);
        Student.AddToTail(10);
        Student.AddToTail(12);
        Student.PrintList();
        
        SLL Course = new SLL(30);
        Course.AddToHead(5);
        Course.AddToHead(6);
        Course.AddToHead(8);
        Course.AddToTail(10);
        Course.AddToTail(12);
        Course.PrintList();
        Course.Enroll(1, 5, 10);
        Student.Enroll(0, 5, 10);
        Course.PrintEnrolled(1, 5, 10);
        Student.PrintEnrolled(0, 5, 10);
    }
    
}