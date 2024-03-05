public class User {
    private String userName;
    private String password;
    private int age;
    private char sex;
    private String email;

    User(String userName, String password, int age, char sex, String emial) throws Exception{
        setUserName(userName);
        setPassword(password);
        setAge(age);
        setSex(sex);
        setEmail(email);

    }

    // passanger
    User(String userName, int age, char sex){

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public char getSex() {
        return sex;
    }
    public String getEmail() {
        return email;
    }
}
