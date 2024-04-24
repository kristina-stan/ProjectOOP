package tikets;

import utilitys.Event;

public class BookedTicket extends Ticket{

    private String note;

    public BookedTicket(Event event, int row, int seatNumber, String note) throws Exception{
        super(event, event.getDate(), row, seatNumber);
        this.note = note;
    }


    @Override
    public boolean isMatchingEvent(Event event) {
        return false;
    }

    @Override
    public boolean isMatchingDate(String date) {
        return super.date.equals(date);
    }

    @Override
    public boolean isMatchingSeat(int row, int seatNumber) {
        return super.reservedSeat.isMatchingSeat(row,seatNumber);
    }
}
