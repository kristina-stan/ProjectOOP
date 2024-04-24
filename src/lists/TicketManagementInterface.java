package lists;

import tikets.BookedTicket;
import tikets.BoughtTicket;
import utilitys.Event;

public interface TicketManagementInterface {

    public void bookTicket(Event event, int row, int seat,String note) throws Exception;
    public void unbookTicket(Event event, int row, int seat);

    public void buyTicket(Event event, int row, int seat);
    void buyBookedTicket(Event event, int row, int seat);

    BookedTicket getTicket(Event event, int row, int seat);
    BoughtTicket getTicket(String uniqueCode);


}
