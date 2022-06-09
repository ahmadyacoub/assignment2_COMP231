import java.util.Date;
import java.util.Scanner;
public class DriverTest {
    public static void gradeAvg(Student[][] students, int i) {  // a method to find the grade average by class

        double avg = 0;
        double sum = 0;
        for (int j = 0; j < students[i].length; j++) {        // LOOP TO SUM THE GRADES TO GET AVG

            sum += students[i][j].getGrade();
            avg = sum / students[i].length;

        }
        // System.out.println("The grade average for class #" + (i + 1) + " = " + (sum /
        // students[i].length));
        System.out.printf("The grade average for claas #" + (i + 1) + " = " + "%.2f", avg);
        // I USED THE "PRINTF" TO
        // FORMAT THE DOUBLE AVERAGE

    }

    public static void printAssignment(Student[][] students) {
        for (int i = 0; i < students.length; i++) {


            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(" CLASS NO #" + (i + 1) + " " + " ORDERING ");
            for (int j = 0; j < students[i].length; j++) {
                System.out.println("Student name : " + students[i][j].getFirstName().toUpperCase() + " "
                        + students[i][j].getLastName().toUpperCase() + " email : "
                        + students[i][j].getEmail() + " " + " grade : " + students[i][j].getGrade());

            }
            gradeAvg(students, i); // TO GET CLASS GRADE AVG
            System.out.println(); // to print new line

            System.out.println("---------------------------------------------------------------------------------");

        }

    }

    public static void sort(Student[] s) {

        char c = 'a';
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; ) {
                int count1 = 0;
                for (int k = 0; k < s[i].getLastName().length(); k++) {
                    if (Character.toLowerCase(s[i].getLastName().charAt(k)) == c)
                        count1++;
                }
                int count2 = 0;
                for (int k = 0; k < s[j].getLastName().length(); k++) {
                    if (Character.toLowerCase(s[j].getLastName().charAt(k)) == c)
                        count2++;
                }
                if (count1 == count2) { // CHECKING IF THE NUMBER OF OCCURED CHAR IN THE STRING OF LAST NAME
                    //HERE WE ARE CHECKING IF Char c occured in first name ==  the second name
                    c++; // turning into the next letter
                } else if (count2 > count1) {
                    Student temp = s[i]; // a save the Student in  a temp student
                    s[i] = s[j]; // to swap between the students
                    s[j] = temp;
                    j++;
                    c = 'a';  //return c to first of alphapet

                } else {  // if count2 <count1
                    j++;
                    c = 'a';  //return c to first of alphapet
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.print("Please enter the number of classes : "); // getting the number of classes
        int numOfClasses = num.nextInt();

        while (numOfClasses < 0) {  // adding an expection for invalid values

            System.out.println("INVALID Enter the number of classes again ");
            numOfClasses = num.nextInt();
        }
        Student[][] students = new Student[numOfClasses][]; // Declaring  students array from class Student
        for (int i = 0; i < numOfClasses; i++) {
            System.out.println(
                    "Please enter the number of students in Class # " + (i + 1) + "  (MUST BE BETWEEN 1 AND 100): ");
            int m = num.nextInt();
            while (m < 1 || m > 100) {      // adding an expection for invalid values
                System.out.println("INVALID RE ENTER THE NUMBER OF STUDENTS");
                m = num.nextInt();

            }
            students[i] = new Student[m];       // to build a ragged array
            for (int j = 0; j < students[i].length; j++) {

                String firstName, lastName;
                Date dateOfBirth;

                System.out.print("Please enter the FULL NAME for student number #" + (j + 1) + " in class number #"
                        + (i + 1) + ": ");
                firstName = num.next();
                //System.out.print("Please enter the last name for student number #"  !! A SECOND WAY
                // + (j + 1) + " in class number #" + (i + 1) + " : ");
                lastName = num.next();
                System.out.print((firstName + lastName).toUpperCase()
                        + " date of birth (enter day then month and  year ) : ");
                int year, month, day;

                day = num.nextInt();
                month = num.nextInt() - 1;
                year = (num.nextInt() - 1900);
                dateOfBirth = new Date(year, month, day);
                String email = "";

                students[i][j] = new Student(firstName, lastName, email, dateOfBirth); // CALL THE CONSTRUCTER
                int id = (i * 1000) + j;
                students[i][j].setId(id);  // OPTIONAL TO GIVE AN UNIQUE ID

            }

        }

        for (int i = 0; i < students.length; i++) {
            sort(students[i]);  // CALL THE SORT METHOD TO SORT THE ARRAY OF Student
            for (int j = 0; j < students[i].length; j++) {  // FOR LOOP TO GET THE GRADE FOR ARRAY OF SORTED STUDENTS
                System.out.print("enter " + " " + (students[i][j].getFirstName() + " "
                        + students[i][j].getLastName()).toUpperCase()
                        + " Grade : ");
                students[i][j].setGrade(num.nextDouble());

            }
        }

        printAssignment(students); // calling the print method to print the array

    }


}