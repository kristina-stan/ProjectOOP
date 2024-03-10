package Clients;

public class Passenger {

    private String name;
    private int age;
    private char sex;
    private boolean hasDiscount;


    Passenger(String name, int age, char sex) throws Exception{
        setName(name);
        setAge(age);
        setSex(sex);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public char getSex() {
        return sex;
    }
}
