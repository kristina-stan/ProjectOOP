package repository;

import tickets.BookedTicket;
import tickets.BoughtTicket;

import java.util.ArrayList;

public class TicketRepository {

    private ArrayList<BookedTicket> bookedTickets;
    private ArrayList<BoughtTicket> boughtTickets;

    public TicketRepository(ArrayList<BookedTicket> bookedTickets, ArrayList<BoughtTicket> boughtTickets){
        this.bookedTickets = bookedTickets;
        this.boughtTickets = boughtTickets;
    }

    //BOOKED TICKETS
    public void addBookedTicket(BookedTicket ticket) {
        bookedTickets.add(ticket);
    }
    public void removeBookedTicket(BookedTicket ticket) {
        bookedTickets.remove(ticket);
    }
    public ArrayList<BookedTicket> getBookedTickets() {
        return bookedTickets;
    }
    public BookedTicket getBookedTicket(int seatNumber){
        for(BookedTicket bookedTicket : bookedTickets){
            if(bookedTicket.getSeatNumber() == seatNumber){
                return bookedTicket;
            }
        }
        return null;
    }

    //BOUGHT TICKETS
    public void addBoughtTicket(BoughtTicket ticket) {
        boughtTickets.add(ticket);
    }
    public void removeBoughtTicket(BoughtTicket ticket) {
        boughtTickets.remove(ticket);
    }
    public ArrayList<BoughtTicket> getBoughtTickets() {
        return boughtTickets;
    }

    public void buyBookedTicket(int seatNumber) throws Exception{
        //find bookedTicket
        BookedTicket bookedTicket = getBookedTicket(seatNumber);
        //get booked ticket info and make it bought ticket
        BoughtTicket boughtTicket = new BoughtTicket(bookedTicket.getEvent(),
                bookedTicket.getBookedSeat().getRowSeat(),
                bookedTicket.getBookedSeat().getSeatNumber()
        );
        //add-remove the ticket
        bookedTickets.remove(bookedTicket);
        boughtTickets.add(boughtTicket);
    }

    public void printBookedTickets(){

        System.out.println("Available Tickets:");
        // Print all tickets on <date> <event>
        for (BookedTicket bookedTicket : bookedTickets) {
            bookedTicket.printTicketInfo();
        }

    }
}
