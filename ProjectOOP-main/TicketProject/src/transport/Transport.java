package transport;

public abstract class Transport {

    private String route;
    private int[] seatNumber;

    Transport(String route, int numberSeats) throws Exception{
       setRoute(route);
       setSeatNumber(numberSeats);
    }



    public void setRoute(String route) {
        this.route = route;
    }
    public void setSeatNumber(int numberSeats) {
        this.seatNumber = new int[numberSeats];
    }

    public String getRoute() {
        return route;
    }
    public int[] getSeatNumber() {
        return seatNumber;
    }
}
