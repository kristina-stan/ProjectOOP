package Clients;

public class Passenger {

    private String name;
    private int age;
    private char gender;
    //private boolean hasDiscount;


    Passenger(String name, int age, char gender) throws Exception{
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
}
