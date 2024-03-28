package entity;
import java.time.LocalDate;

public class Event {

    private LocalDate date;
    private Hall hall;
    private String eventName;
    private int hallCapacity;

    //add event
    public Event(LocalDate date, Hall hall, String eventName) throws Exception{

        setDate(date);
        setHall(hall);
        setNameEvent(eventName);
        this.hallCapacity = 0;
    }

    public void printEventSeats(){
        System.out.println("\"" + eventName + "\" on the "+ date.toString());
        hall.printHallSeats();
    }

    public boolean isHallCapasityReached() {
        if(hallCapacity == this.hall.getNumberSeats())
            return true;
        return false;
    }

    public void capacityRegulationIncrease(){
        hallCapacity++;
    }
    public void capacityRegulationDecrease(){
        hallCapacity--;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    public void setNameEvent(String eventName) throws Exception{
        if(eventName.isEmpty()){
            throw new Exception("The event has to have a name!");
        }
        this.eventName = eventName;
    }

    public int getEventHallNumber(){
        return hall.getHallNumber();
    }
    public LocalDate getDate() {
        return date;
    }
    public Hall getHall() {
        return hall;
    }
    public String getEventName() {
        return eventName;
    }

}
