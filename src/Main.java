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
        
        StackRedo SR = new StackRedo();
        StackUndo SU = new StackUndo();
        SU.SetRedo(SR);
        SR.SetUndo(SU);
//
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
            System.out.println("15-Undo Last Action");
            System.out.println("16-Redo Last Action");
            System.out.println("0-Exit\n");

            Choice = input.nextInt();
            input.nextLine();

            switch (Choice) {
                case 1:{

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
                    
                    break;}
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
                case 3:{
                    System.out.println ("Enter the student's ID to remove : ");
                    StudentID = input.nextLong();
                    Student_Node temp = Students.binarySearch (StudentID);
                    if(temp == null){
                        System.out.println("\nThe student doesn't exist.\n");
                        break;
                    } else if(temp.first_course != null){
                        System.out.println ("The student has registered courses.\n");
                        System.out.println ("Do you want to remove the student ? (1 / 0) : \n");
                        System.out.println ("\"This will delete all the enrollments that the student has registered.\"\n");
                        int remove = input.nextInt();
                        if(remove == 1){
                            Enrollment_Node temp1 = temp.first_course;
                            while(temp1 != null){
                                Students.binarySearch (StudentID).removeEnrollment(temp1.course.ID, Courses);
                                temp1 = temp1.next_student;
                            }
                            Students.removeStudent (temp);
                            System.out.println ("The course was removed successfully.\n");
                        }
                    }else {
                        Students.removeStudent (temp);
                        System.out.println ("The student was removed successfully.\n");
                    }
                    break;}
                case 4:{
                    System.out.println ("Enter the course's ID to remove: ");
                    CourseID = input.nextLong();
                    Course_Node temp = Courses.binarySearch (CourseID);
                    if(temp == null){
                        System.out.println("\nThe course doesn't exist.\n");
                        break;
                    } else if(temp.first_student != null){
                        System.out.println ("The course has enrolled students.\n");
                        System.out.println ("Do you want to remove the course ? (1 / 0) : \n");
                        System.out.println ("\"This will delete all the enrollments in the course.\"\n");
                        int remove = input.nextInt();
                        if(remove == 1){
                            Enrollment_Node temp1 = temp.first_student;
                            while(temp1 != null){
                                Students.binarySearch (temp1.student.ID).removeEnrollment(CourseID, Courses);
                                temp1 = temp1.next_student;
                            }
                            Courses.removeCourse (temp);
                            System.out.println ("The course was removed successfully.\n");
                        }
                    }else {
                        Courses.removeCourse (temp);
                        System.out.println ("The student was removed successfully.\n");
                    }
                    break;}
                case 5:{
                    if(Students.is_Empty()){
                        System.out.println("\nThere are no Students added yet , do you wanna add Student ? (1 / 0)");
                        int choice = input.nextInt();
                        if (choice == 1) {System.out.println("Enter Student's ID :");
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
                    else if (Students.last_added==null){
                        System.out.println ("The last student added was deleted.\n");
                        break;
                    }
                    System.out.println ("The last student added was: " + Students.last_added.name);
                    break;}
                case 6:
                    if(Courses.is_Empty()){
                        System.out.println("\nThere are no Courses added yet , do you wanna add Student ? (1 / 0)");
                        int choice = input.nextInt();
                        if (choice == 1) {

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
                    else if (Students.last_added==null){
                        System.out.println ("The last course added was deleted.\n");
                        break;
                    }
                    System.out.println ("The last course added was: " + Courses.last_added.name);
                    break;
                case 7:{

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

                                System.out.println("\nThe Student doesn't exist.\n");
                            }else{
                                System.out.println("Enter Course's ID To Enroll : ");
                                CourseID = input.nextLong();

                                if(!Courses.isExist(CourseID)){
                                    System.out.println("\nThe course doesn't exist.\n");
                                }else{

                                    if (Students.binarySearch(StudentID).isRegistered(CourseID, Courses)) {
                                        System.out.println("\nStudent has already enrolled this course.\n");
                                    }else if(Students.binarySearch(StudentID).isFullOfCourses()){
                                        System.out.println("\nThe student registered for the maximum number of courses.\n");
                                    } else if(Courses.binarySearch(CourseID).isFullCourse()){
                                        System.out.println("\nThe course has the maximum number of students registered.\n");
                                    }else{
                                        Students.binarySearch(StudentID).enroll(CourseID,Courses);
                                        SU.Push(Students.binarySearch(StudentID).last_course);
                                        SU.removeTop ();
                                        System.out.println("\nThe course has been successfully enrolled.\n");
                                    }
                                }
                            }
                        }
                    }
            
                    break;}
                case 8:{

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

                        System.out.println("\nThe student doesn't exist.\n");

                    }else{

                        System.out.println("Enter Course's ID : ");
                        CourseID = input.nextLong();
                        
                        if(!Courses.isExist(CourseID)){
                            System.out.println("\nThe course doesn't exist.\n");
                        }else{
                            Students.binarySearch (StudentID).removeEnrollment(CourseID, Courses);
                        }
                    }
                }

                    break;}
                    
                case 9:{
                if(Students.is_Empty()){

                    System.out.println("\nThere are no students added yet.\n");
                }else{

                    System.out.println("Enter Student's ID : ");
                    StudentID = input.nextLong();

                    if(!Students.isExist(StudentID)){
                        System.out.println("\nThe student is not exist.\n");
                    }else{

                        Students.binarySearch(StudentID).displayCourses();
                    }
                }

                    break;}
                case 10:{

                    if(Courses.is_Empty()){

                        System.out.println("\nThere are no courses added yet.\n");
                    }else{

                        System.out.println("Enter Course's ID : ");
                        CourseID = input.nextLong();

                        if(!Courses.isExist(CourseID)){

                            System.out.println("\nThe course is not exist.\n");
                        }else{

                            Courses.binarySearch(CourseID).displayStudents();
                        }
                    }

                    break;}
                case 11:{
                    if(Courses.is_Empty()){

                        System.out.println("\nThere are no courses added yet.\n");
                    }else{

                        System.out.println("Enter Course's ID : ");
                        CourseID = input.nextLong();

                        if(!Courses.isExist(CourseID)){

                            System.out.println("\nThe course is not exist.\n");
                        }else{

                            Courses.binarySearch(CourseID).displaySortedStudents();
                        }
                    }

                    break;}
                case 12:
                    if(Students.is_Empty()){

                        System.out.println("\nThere are no students added yet.\n");
                    }else{

                        System.out.println("Enter student's ID : ");
                        StudentID = input.nextLong();

                        if(!Courses.isExist(StudentID)){

                            System.out.println("\nThe student doesn't exist.\n");
                        }else{

                            Students.binarySearch(StudentID).displaySortedCourses();
                        }
                    }
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
                                System.out.println("\nThe course is not completed.");
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
                case 15:

                    if(SU.isEmpty()){
                        System.out.println("\nThere is no undo to do.\n");
                    }else{
                        SU.Undo();
                        System.out.println("\nThe last action was undone.\n");
                    }

                    break;
                case 16:

                    if(SR.isEmpty()){
                        System.out.println("\nThere is no redo to do.\n");
                    }else{
                        SR.Redo();
                        System.out.println("\nThe last action was redone.\n");
                    }

                    break;
                case 0:

                    System.out.println("\n\t\t\tExiting The System ;)\n");

                    break;
                default:
                    System.out.println("\nWrong Choice , Please Choose a Number Between (0:14)\n");

                    break;
            }
            System.out.println("Undo Stack : ");
            SU.display();
            System.out.println("Redo Stack : ");
            SR.display();
        } while(Choice != 0);
        
    }
}