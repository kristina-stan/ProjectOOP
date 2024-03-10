package ticket;

public class TrainTicket extends Ticket{

    TrainTicket(String date, String type, String origin, String destination,
                double price, int numberPassengers) throws Exception{
        super(date, type, origin, destination, price, numberPassengers);

    }

    @Override
    public void buyTicket() {

    }

}
