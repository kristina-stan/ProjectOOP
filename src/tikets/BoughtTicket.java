package tikets;

import utilitys.DateManager;
import utilitys.Event;
import utilitys.Seat;

public class BoughtTicket extends Ticket{

    private String uniqueCode;
    protected Seat boughtSeat;

    public BoughtTicket(Event event, int row, int seatNumber) throws Exception{
        super(event, event.getDate(), row, seatNumber);
        setBoughtSeat(row,seatNumber);
        setUniqueCode();
    }

    public void setUniqueCode(){

    }
    public void setBoughtSeat(int row, int seatNumber) throws Exception{
        this.boughtSeat = event.getSeats().getSeat(row,seatNumber);
        event.getSeats().boughtSeat(boughtSeat);
        this.boughtSeat.setBought(true);
    }

    public String getUniqueCode() {
        return uniqueCode;
    }
    public Seat getBoughtSeat() {
        return boughtSeat;
    }

    @Override
    public boolean isMatchingEvent(Event event) {
        return false;
    }

    @Override
    public boolean isMatchingDate(DateManager date) {
        return super.date.equals(date);
    }

    @Override
    public boolean isMatchingSeat(int row, int seatNumber) {
        return boughtSeat.isMatchingSeat(row,seatNumber);
    }
}
