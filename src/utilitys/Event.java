package utilitys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event {

    private Hall hall;
    private String name;
    private DateManager date;
    private AllSeats seats;
    private int capacity;

    public Event(Hall hall, String name, String date) throws Exception{

        this.hall = hall;
        setName(name); // event name
        setCapacity(hall.getRows()*hall.getSeatsPerRow()); // total capasity
        setSeats(new AllSeats(hall.getRows(),hall.getSeatsPerRow())); // set seats
        setDate(date);
    }

    public void printEventSeats(){
        System.out.println("\"" + name + "\" on the "/*+ getFormattedDate()*/);
        seats.printAllSeats();
    }

    public void setName(String name) throws Exception{
        if(!name.matches("[a-zA-Z0-9 ':]+"))
            throw new Exception("Invalid event name!");
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setSeats(AllSeats seats) {
        this.seats = seats;
    }
    public void setDate(String date) throws Exception{
        this.date = new DateManager(date); // Using DateManager for date parsing and validation
    }


    public String getName() {
        return name;
    }
    public int getHallNumber() {
        return hall.getNumber();
    }
    public int getCapacity() {
        return capacity;
    }
    public AllSeats getSeats() {
        return seats;
    }
    public Hall getHall(){
        return this.hall;
    }
    public String getDate() {
        return date.toString();
    }
   /* public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.date.getDate().format(formatter);
    }*/

    public boolean isMatching(String date) throws IllegalArgumentException {
        try {
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return this.date.getDate().isEqual(parsedDate);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format! Please use the format yyyy-MM-dd");
        }
    }
    public boolean isMatching(Hall hall){
        return this.hall == hall;
    }
    public boolean isMatchingName(String eventName){
        return this.name.equals(eventName);
    }
}
