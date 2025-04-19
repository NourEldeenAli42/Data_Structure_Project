import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Course_List Courses = new Course_List();

        Student_List Students = new Student_List();


        int Choice;
        long StudentID ;
        int CourseID;
        String StudentName , CourseName;
        int StudentAge;
        double StudentGPA;


        do { 
            System.out.println("\n\t\t\tWelcome to University Course Registration !");
            System.out.println("__________________________________________________________________________________________\n");
            System.out.println("1-Add Student");
            System.out.println("2-Add Course");
            System.out.println("3-Remove Student");
            System.out.println("4-Remove Course");
            System.out.println("5-Get Last Student Added");
            System.out.println("6-Get Last Course Added");
            System.out.println("7-Enroll Student");
            System.out.println("8-Remove Enrollment");
            System.out.println("9-List Courses By Students");
            System.out.println("10-List Students By Courses");
            System.out.println("11-Sort Students By ID");
            System.out.println("12-Sort Courses By ID");
            System.out.println("13-Is Full Course ?");
            System.out.println("14-Is Normal Student ?");
            System.out.println("0-Exit\n");

            Choice = input.nextInt();
            input.nextLine();

            switch (Choice) {
                case 1:

                    System.out.println("Enter Student's ID");
                    StudentID = input.nextLong();

                    if(Students.isExist(StudentID)){

                        System.out.println("\nStudent is already exist.");
                    }
                    else{
                        input.nextLine();

                        System.out.println("Enter Student's Name");
                        StudentName = input.nextLine();
                        System.out.println("Enter Student's Age");
                        StudentAge = input.nextInt();
                        System.out.println("Enter Student's GPA");
                        StudentGPA = input.nextDouble();

                        Students.addStudent(StudentID,StudentName,StudentAge,StudentGPA);

                        System.out.println("\nStudent Was Added Successfully");

                    }
                    
                    break;
                case 2:

                System.out.println("Enter Course's ID");
                CourseID = input.nextInt();

                if(Courses.isExist(CourseID)){

                    System.out.println("/nCourse is already exist.");
                }
                else{
                    input.nextLine();
                    System.out.println("Enter Course's Name");
                    CourseName = input.nextLine();
    
                    Courses.addCourse(CourseID,CourseName);
    
                    System.out.println("\nCourse Was Added Successfully");
    
                }
                    
                    break; 
                case 3:
                    
                    break;
                case 4:

                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    System.out.println("Enter Student's ID");
                    StudentID = input.nextLong();

                    Students.binarySearch(StudentID).display_courses();

                    break;
                case 10:
                    System.out.println("Enter Course's ID");
                    CourseID = input.nextInt();

                    Courses.binarySearch(CourseID).display_students();
                    break;
                case 11:
                    
                    break;
                case 12:
                    
                    break;
                case 13:
                    System.out.println("Enter Course's ID");
                    CourseID = input.nextInt();

                    if(Courses.binarySearch(CourseID).isFullCourse()){
                        System.out.println("Course is completed");
                    }
                    else{
                        System.out.println("Course is not copmleted");
                    }

                    break;
                case 14:
                    System.out.println("Enter Student's ID");
                    StudentID = input.nextLong();

                    if(Students.binarySearch(StudentID).isNormalStudent()){
                        System.out.println("Student is normal student");
                    }
                    else {
                        System.out.println("Student is not a normal student");
                    }

                    break;
                default:
                    throw new AssertionError();
            }

        } while(Choice != 0);
        
    }
}