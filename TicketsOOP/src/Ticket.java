public class Ticket {

    private int code;
    private Event event; // date/name/row/seat
    private Seat visitorSeat;
    private String note;
    private boolean isPaid;

    Ticket(Event event, int row, int reservedSeat, String note) throws Exception{

        //generateCode
        setEvent(event);
        setVisitorSeat(row, reservedSeat, true);
    }

    public void setEvent(Event event) throws Exception{
        this.event = event;
    }

    public void setVisitorSeat(int row, int reservedSeat, boolean status){
        this.event.getHall().setSeatStatus(row, reservedSeat, status);
    }

    public Event getEvent() {
        return event;
    }
}
