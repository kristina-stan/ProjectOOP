package tickets;

import entity.*;

public abstract class Ticket {

    //private UUID uniqueCode;
    private Event event; // date/name/row/seat
    private Seat bookedSeat;

    public Ticket(Event event, int row, int reservedSeat) throws Exception{

        setEvent(event);
        setBookedSeat(row, reservedSeat, false);
    }

    public void setEvent(Event event){
        this.event = event;
    }
    public void setBookedSeat(int row, int reservedSeat, boolean status){
        this.bookedSeat = new Seat(row, reservedSeat);
        this.event.getHall().setSeatStatus(row, reservedSeat, status);
    }

    public Event getEvent() {
        return event;
    }
    public Seat getBookedSeat() {
        return bookedSeat;
    }
    public int getSeatNumber(){
        return this.bookedSeat.getSeatNumber();
    }
    public abstract void printTicketInfo();


}
