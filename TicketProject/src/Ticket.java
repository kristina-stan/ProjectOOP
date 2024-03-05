import java.util.Scanner;

public class Ticket {

    private double price;
    private int numberPassangers;
    private boolean oneWay;
    private String date;

    Ticket(double price, int numberPassangers, boolean oneWay, String date) throws Exception{

    }

    public void buyTicket(Scanner scanner){

        System.out.print("Choose transport (bus,train,plane):");
        String option = scanner.nextLine().toLowerCase();

        switch (option){ // different prices
            case "bus":
                break;

            case "train":
                break;

            case "plane":
                break;
        }


    }

    public void travel(Scanner scanner){

        System.out.print("One-way or Two-wat ticket:");
        String option = scanner.nextLine().toLowerCase();

        if(option.equals("one-way") ){

        }else if(option.equals("two-way") ){

        }

    }

    public void





    public void setPrice(double price) {
        this.price = price;
    }
    public void setNumberPassangers(int numberPassangers) {
        this.numberPassangers = numberPassangers;
    }
    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }
    public int getNumberPassangers() {
        return numberPassangers;
    }
    public boolean isOneWay() {
        return oneWay;
    }
    public String getDate() {
        return date;
    }
}
