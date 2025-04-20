import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Course_List Courses = new Course_List();
    
        Student_List Students = new Student_List();
        
        int Choice;
        long StudentID, CourseID;
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

                    System.out.println("Enter Student's ID :");
                    StudentID = input.nextLong();

                    if(Students.isExist(StudentID)){

                        System.out.println("\nThe Student is already exist.\n");
                    }
                    else{
                        input.nextLine();
                        System.out.println("Enter Student's Name : ");
                        StudentName = input.nextLine();
                        System.out.println("Enter Student's Age : ");
                        StudentAge = input.nextInt();
                        System.out.println("Enter Student's GPA : ");
                        StudentGPA = input.nextDouble();

                        Students.addStudent(StudentID,StudentName,StudentAge,StudentGPA);

                        System.out.println("\nThe student Was Added Successfully.\n");
                    }
                    
                    break;
                case 2:

                    System.out.println("Enter Course's ID : ");
                    CourseID = input.nextLong();

                    if(Courses.isExist(CourseID)){
                        System.out.println("\nThe course is already exist.\n");
                    }
                    else{
                        input.nextLine();
                        System.out.println("Enter Course's Name : ");
                        CourseName = input.nextLine();
    
                        Courses.addCourse(CourseID,CourseName);
    
                        System.out.println("\nThe course Was Added Successfully.\n");
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

                    if(Students.is_Empty()){
                        int addOne;

                        System.out.println("\nThere are no Students added yet , do you wanna add Student ? (1 / 0)");
                        addOne = input.nextInt();


                        if(addOne == 1){
                            
                            System.out.println("Enter Student's ID :");
                            StudentID = input.nextLong();

                            if(Students.isExist(StudentID)){

                                System.out.println("\nThe Student is already exist.\n");
                            }
                            else{
                                input.nextLine();
                                System.out.println("Enter Student's Name : ");
                                StudentName = input.nextLine();
                                System.out.println("Enter Student's Age : ");
                                StudentAge = input.nextInt();
                                System.out.println("Enter Student's GPA : ");
                                StudentGPA = input.nextDouble();

                                Students.addStudent(StudentID,StudentName,StudentAge,StudentGPA);

                                System.out.println("\nThe student Was Added Successfully.\n");

                            }
                        }
                    }

                    if(!Students.is_Empty()){

                        if(Courses.is_Empty()){

                            int addOne;
    
                            System.out.println("\nThere are no Courses added yet , do you wanna add Course ? (1 / 0)");
                            addOne = input.nextInt();
    
                            if(addOne == 1){
    
                                System.out.println("Enter Course's ID : ");
                                CourseID = input.nextLong();
            
                                if(Courses.isExist(CourseID)){
                                    System.out.println("\nThe course is already exist.\n");
                                }
                                else{
                                    input.nextLine();
                                    System.out.println("Enter Course's Name : ");
                                    CourseName = input.nextLine();
                
                                    Courses.addCourse(CourseID,CourseName);
                
                                    System.out.println("\nThe course Was Added Successfully.\n");
                                }
                            }
                        }

                        if(!Courses.is_Empty()){

                            System.out.println("Enter Student's ID To Enroll : ");
                            StudentID = input.nextLong();
                            if(!Students.isExist(StudentID)){

                                System.out.println("\nThe Student is not exist.\n");
                            }else{
                                System.out.println("Enter Course's ID To Enroll : ");
                                CourseID = input.nextLong();

                                if(!Courses.isExist(CourseID)){
                                    System.out.println("\nThe course is not exist.\n");
                                }else{

                                    if(Students.binarySearch(StudentID).isFullOfCourses()){
                                        System.out.println("\nThe student registered for the maximum number of courses.\n");
                                    } else if(Courses.binarySearch(CourseID).isFullCourse()){
                                        System.out.println("\nThe course has the maximum number of students registered.\n");
                                    }else{
                                        Students.binarySearch (StudentID).enroll (CourseID,Courses);
                
                                        System.out.println("\nThe course has been successfully enrolled.\n");
                                    }
                                }
                            }
                        }
                    }
            
                    break;
                case 8:

                    if(Students.is_Empty())
                    {
                        System.out.println("\nThere are no students to remove.\n");
                    }
                    else if(Courses.is_Empty())
                    {
                        System.out.println("\nThere are no courses to remove.\n");
                    }
                    else
                    {
                        System.out.println("Enter Student's ID :");
                        StudentID = input.nextLong();
                        if(!Students.isExist(StudentID)){

                        System.out.println("\nThe student is not exist.\n");

                    }else{

                        System.out.println("Enter Course's ID : ");
                        CourseID = input.nextLong();
                        
                        if(!Courses.isExist(CourseID)){
                            System.out.println("\nThe course is not exist.\n");
                        }else{
                            Students.binarySearch (StudentID).removeEnrollment(CourseID, Courses);
                        }
                    }
                }

                    break;
                    
                case 9:
                if(Students.is_Empty()){

                    System.out.println("\nThere are no students added yet.\n");
                }else{

                    System.out.println("Enter Student's ID : ");
                    StudentID = input.nextLong();

                    if(!Students.isExist(StudentID)){
                        System.out.println("\nThe student is not exist.\n");
                    }else{

                        Students.binarySearch(StudentID).display_courses();
                    }
                }

                    break;
                case 10:

                    if(Courses.is_Empty()){

                        System.out.println("\nThere are no courses added yet.\n");
                    }else{

                        System.out.println("Enter Course's ID : ");
                        CourseID = input.nextLong();

                        if(!Courses.isExist(CourseID)){

                            System.out.println("\nThe course is not exist.\n");
                        }else{

                            Courses.binarySearch(CourseID).display_students();
                        }
                    }

                    break;
                case 11:
                    
                    break;
                case 12:
                    
                    break;
                case 13:
                    if(Courses.is_Empty()){

                        System.out.println("\nThere are no courses added yet.\n");
                    }else{

                        System.out.println("Enter Course's ID : ");
                        CourseID = input.nextInt();

                        if(!Courses.isExist(CourseID)){
                            System.out.println("\nThe course is not exist.\n");
                        }else{
                            if(Courses.binarySearch(CourseID).isFullCourse()){
                                System.out.println("\nThe course is completed.");
                            }
                            else{
                                System.out.println("\nThe course is not copmleted.");
                            }
                        }
                    }

                    break;
                case 14:

                    if(Students.is_Empty()){

                        System.out.println("\nThere are no students added yet.\n");
                    }else{

                        System.out.println("Enter Student's ID : ");
                        StudentID = input.nextLong();
                        if(!Students.isExist(StudentID)){

                            System.out.println("\nThe student is not exist.\n");
                        }else{

                            if(Students.binarySearch(StudentID).isNormalStudent()){
                                System.out.println("\nThe student is normal student.");
                            }
                            else {
                                System.out.println("\nThe student is not a normal student.");
                            }
                        }
                    }

                    break;
                case 0:

                    System.out.println("\n\t\t\tExiting The System ;)XD\n");

                    break;
                default:
                    System.out.println("\nWrong Choice , Please Choose a Number Between (0:14)\n");

                    break;
            }

        } while(Choice != 0);
        
    }
}