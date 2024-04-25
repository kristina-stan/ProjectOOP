package tikets;

import utilitys.DateManager;
import utilitys.Event;
import utilitys.Seat;

public class BookedTicket extends Ticket{

    private String note;
    protected Seat reservedSeat;

    public BookedTicket(Event event, int row, int seatNumber, String note) throws Exception{
        super(event, event.getDate(), row, seatNumber);
        this.setReservedSeat(row,seatNumber);
        this.note = note;
    }

    public void setReservedSeat(int row, int seatNumber) throws Exception{
        this.reservedSeat = event.getSeats().getSeat(row,seatNumber);
        event.getSeats().reserveSeat(reservedSeat);
        this.reservedSeat.setReserved(true);
    }
    public Seat getReservedSeat() {
        return reservedSeat;
    }

    @Override
    public boolean isMatchingEvent(Event event) {
        return this.event.equals(event);
    }

    @Override
    public boolean isMatchingDate(DateManager date) {
        return super.date.equals(date);
    }

    @Override
    public boolean isMatchingSeat(int row, int seatNumber) {
        return reservedSeat.isMatchingSeat(row+1,seatNumber+1);
    }
}
