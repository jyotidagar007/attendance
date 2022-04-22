package nic.oad.attendance.dto;

public class StudentDto {
    private String firstName;
    private String lastName;
    private int rollNo;
    private int studentClass;
    // private String role = "ROLE_ADMIN";

    public StudentDto(){

    }

    public StudentDto(String firstName, String lastName, int rollNo, int studentClass) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        //  this.role = role;
    }

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
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public int getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rollNo=" + rollNo +
                ", standard=" + studentClass +
                '}';
    }

}
