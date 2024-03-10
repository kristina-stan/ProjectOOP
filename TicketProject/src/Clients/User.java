package Clients;

public class User extends Passenger {

    private String userName;
    private String password;
    private String email;
    private int phoneNumber;

    User(String name, int age, char sex, String userName, String password,
         String email, int phoneNumber) throws Exception{

        super(name, age, sex);
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    public int getPhoneNumber() {
        return phoneNumber;
    }
}
