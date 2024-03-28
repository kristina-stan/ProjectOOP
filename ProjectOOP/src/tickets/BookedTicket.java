package tickets;
import entity.Event;

public class BookedTicket extends Ticket {

    private String note;

    BookedTicket(Event event, int row, int reservedSeat, String note)
            throws Exception{
        super(event,row,reservedSeat);
        setNote(note);
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
    public void printTicketInfo(){
        System.out.println("Booked Ticket: " + getEvent().getEventName() +
                ", Date: " + getEvent().getDate() +
                ", Seat: " + getBookedSeat().getRowSeat() +
                ", " + getBookedSeat().getSeatNumber() +
                ", Note: " + getNote());
    }

}
