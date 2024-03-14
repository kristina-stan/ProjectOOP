import java.time.LocalDate;

public class Event {

    private LocalDate date;
    private Hall hall;
    private String eventName;

    //add event
    public Event(LocalDate date, Hall hall, String eventName) throws Exception{

        setDate(date);
        setHall(hall);
        setNameEvent(eventName);

    }

    public void printEventSeats(){
        System.out.println("\"" + eventName + "\" on the "+ date.toString());
        hall.printHallSeats();
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
