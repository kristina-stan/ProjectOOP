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
    protected Seat reservedSeat;

    public Ticket(Event event, String date, int row, int seatNumber) throws Exception{
        this.event = event;
        setDate(date);
        event.getSeats().reserveSeat(row, seatNumber); // reserve Seat in event
        setReservedSeat(row, seatNumber); // save seat info in the ticket class
    }

    public void setDate(String date) throws Exception{
        try {
            this.date = new DateManager(date); // Using DateManager for date parsing and validation
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format! Please provide date in dd-MM-yyyy format.");
        }
    }

    public void setReservedSeat(int row, int seatNumber) throws Exception{
        this.reservedSeat = event.getSeats().getSeat(row,seatNumber);
    }

    public Event getEvent() {
        return event;
    }
    public String getEventName() {
        return event.getName();
    }
    public String getDate() {
        return event.toString();
    }
    /*public String getFormatDate(){
        return event.getFormattedDate();
    }*/
    public Seat getReservedSeat() {
        return reservedSeat;
    }

    public abstract boolean isMatchingEvent(Event event);
   // public abstract boolean isMatchingEvent(String eventName);
    public abstract boolean isMatchingDate(String date);
    public abstract boolean isMatchingSeat(int row, int seat);

}
