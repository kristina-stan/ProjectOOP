package tikets;

import utilitys.Event;

public class BoughtTicket extends Ticket{

    private String uniqueCode;

    public BoughtTicket(Event event, int row, int seatNumber) throws Exception{
        super(event, event.getDate(), row, seatNumber);
        setUniqueCode();
    }

    public void setUniqueCode(){

    }
    @Override
    public boolean isMatchingEvent(Event event) {
        return false;
    }

    @Override
    public boolean isMatchingDate(String date) {
        return false;
    }

    @Override
    public boolean isMatchingSeat(int row, int seat) {
        return false;
    }
}
