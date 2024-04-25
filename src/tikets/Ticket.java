package tikets;

import utilitys.DateManager;
import utilitys.Event;
import utilitys.Seat;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Ticket {

    protected Event event;
    protected DateManager date;
    //protected Seat reservedSeat;

    public Ticket(Event event, DateManager date, int row, int seatNumber) throws Exception{
        this.event = event;
        setDate(date);
        //event.getHall().getSeats().reserveSeat(row,seatNumber);
        //event.getSeats().reserveSeat(row, seatNumber); // reserve Seat in event
        //setReservedSeat(row, seatNumber); // save seat info in the ticket class
    }

    public void setDate(DateManager date) throws Exception{
        //DateManager parsedDate = new DateManager(date);
        if(date.isValid())
            this.date = date; // Using DateManager for date parsing and validation
        else throw new Exception("You can add an event 4 years in advance!");
    }

    /*public void setReservedSeat(int row, int seatNumber) throws Exception{
        this.reservedSeat = event.getSeats().getSeat(row,seatNumber);
        this.reservedSeat.setReserved(true);
    }*/

    public Event getEvent() {
        return event;
    }
    public String getEventName() {
        return event.getName();
    }
    public DateManager getDate() {
        return event.getDate();
    }
    /*public String getFormatDate(){
        return event.getFormattedDate();
    }*/
    /*public Seat getReservedSeat() {
        return reservedSeat;
    }*/

    public abstract boolean isMatchingEvent(Event event);
   // public abstract boolean isMatchingEvent(String eventName);
    public abstract boolean isMatchingDate(DateManager date);
    public abstract boolean isMatchingSeat(int row, int seat);

}
