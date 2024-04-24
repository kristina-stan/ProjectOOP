package lists;

import tikets.BookedTicket;
import tikets.BoughtTicket;
import utilitys.Event;

import java.util.ArrayList;

public class TicketsManager implements TicketManagementInterface{

    private ArrayList<BookedTicket> bookedTickets;
    private ArrayList<BoughtTicket> boughtTickets;

    public TicketsManager(ArrayList<BookedTicket> bookedTickets,
                          ArrayList<BoughtTicket> boughtTickets){

        this.bookedTickets = bookedTickets;
        this.boughtTickets = boughtTickets;

    }

    public void bookTicket(Event event, int row, int seat, String note) throws Exception{
        bookedTickets.add(new BookedTicket(event,row,seat,note));
    }


    @Override
    public void unbookTicket(Event event, int row, int seat) {

    }

    @Override
    public void buyTicket(Event event, int row, int seat) {

    }

    @Override
    public void buyBookedTicket(Event event, int row, int seat) {

    }

    @Override
    public BookedTicket getTicket(Event event, int row, int seat) {
        return null;
    }

    @Override
    public BoughtTicket getTicket(String uniqueCode) {
        return null;
    }
}
