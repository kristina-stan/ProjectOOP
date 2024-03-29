package tickets;

import entity.Event;
import java.util.UUID;

public class BoughtTicket extends Ticket {

    private final UUID uniqueCode;

    public BoughtTicket(Event event, int row, int reservedSeat) throws Exception{
        super(event, row, reservedSeat);
        this.uniqueCode = UUID.randomUUID();
    }

    public UUID getUniqueCode() {
        return uniqueCode;
    }

    public void printTicketInfo(){

    }
}
