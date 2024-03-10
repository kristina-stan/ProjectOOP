package ticket;

public class BusTicket extends Ticket{

    private int seatNumber;

    BusTicket(String date, String type, String origin, String destination,
              double price, int numberPassengers, int seatNumber) throws Exception{

        super(date, type, origin, destination, price, numberPassengers);
        setSeatNumber(seatNumber);
    }

    @Override
    public void buyTicket() {

    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public int getSeatNumber() {
        return seatNumber;
    }

}
