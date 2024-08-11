package dbms.railway.models;



import java.util.Set;

public class User{
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String AadhaarCard;
    private String DOB;
    private String Gender;
    private String userPassword;
    public User() {

    }

    public User(String username, String firstName, String lastName, String phoneNumber, String email , String AadhaarCard, String DOB, String Gender, String userPassword ) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.AadhaarCard = AadhaarCard;
        this.DOB = DOB;
        this.Gender = Gender;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhaarCard() {
        return AadhaarCard;
    }

    public void setAadhaarCard(String aadhaarCard) {
        AadhaarCard = aadhaarCard;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", AadhaarCard='" + AadhaarCard + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }

}