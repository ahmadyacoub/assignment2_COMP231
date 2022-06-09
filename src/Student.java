import java.util.Date;
public class Student {

    private String firstName;  // DECLARING THE CLASS ATTRIBUTES
    private String lastName;
    private int id;
    private Date dateOfBirth;
    private double grade;
    private String email;

    public Student(String firstName, String lastName,String email, Date dateOfBirth) { //DECLARING THE CONSTRUCTER
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.email=ritajEmail();



    }

    // GETTERS AND SETTERS FOR ATTRIBUTES
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }



    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String ritajEmail(){  // to get the email value
        return firstName.toLowerCase().charAt(0)+lastName.toLowerCase()+"@ritaj.birzeit.edu";
        // i used .tolowercase to convert all letters to lowwercase
    }

}

