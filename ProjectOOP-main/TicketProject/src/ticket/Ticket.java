package ticket;


import discount.Discount;

public abstract class xTicket implements TicketManager {

    private String date;
    private String type; // bus, train, plane
    private String origin; // start point
    private String destination; // end point
    private double price;
    private int numberPassengers;

    Ticket(String date, String type, String origin, String destination,
           double price, int numberPassengers) throws Exception {

        this.date = date;
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.numberPassengers = numberPassengers;
    }

}
