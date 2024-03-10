package Clients;

import java.util.ArrayList;

public class User extends Passenger {

    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private ArrayList<Passenger> passengers;

    User(String name, int age, char gender, String userName, String password,
         String email, String phoneNumber) throws Exception{

        super(name, age, gender);
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        passengers = new ArrayList<>();
    }

    public static User signUp(String name, int age, char gender, String userName, String password,
                              String email, String phoneNumber) throws Exception{

        return new User(name, age, gender, userName, password, email, phoneNumber);
    }

    public boolean existingUser(String userName, String password){
        if(userName.equals(this.userName) || userName.equals(getName()))
            if(password.equals(this.password))
                return true;
        return false;
    }

    public void addPassengers(Passenger passenger){
        passengers.add(passenger);
    }
    public void deleatePassenger(Passenger passenger){
        passengers.remove(passenger);
    }

    public void setUserName(String userName) {
        this.userName = userName.toLowerCase();
    }
    public boolean passwordValidation(String password){
        return password.equals(this.password);
    }
    public void setPassword(String password) {
        this.password = password.toLowerCase();
    }
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.toLowerCase();
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
