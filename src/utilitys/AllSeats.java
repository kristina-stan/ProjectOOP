package utilitys;


public class AllSeats {

    private Seat[][] seats;

    AllSeats(int rows, int seatsPerRow) throws Exception{
        seats = new Seat[rows][seatsPerRow];
        initializeSeats();
    }
    AllSeats(AllSeats allSeats) throws Exception{
        this.seats = new Seat[allSeats.seats.length][allSeats.seats[0].length];
        copySeats(allSeats);
    }
    private void copySeats(AllSeats otherSeats) throws Exception{
        for (int i = 0; i < otherSeats.seats.length; i++) {
            for (int j = 0; j < otherSeats.seats[i].length; j++) {
                this.seats[i][j] = new Seat(i + 1, j + 1);
                this.seats[i][j].setReserved(otherSeats.seats[i][j].isReserved());
            }
        }
    }

    public void initializeSeats() throws Exception{
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                seats[i][j] = new Seat(i+1,j+1);
            }
        }
    }

    public AllSeats getAllSeats(){
        return this;
    }
    public Seat getSeat(int row, int seatNumber) throws Exception{
        isSeatValid(row, seatNumber);
        return seats[row][seatNumber];
    }

    // Change seat status
    public void reserveSeat(Seat seat) throws Exception{
        //isSeatValid(row, seatNumber);
        seat.setReserved(true);
    }
    public void unreserveSeat(Seat seat) throws Exception{
        //isSeatValid(row, seatNumber);
        seat.setReserved(false);
    }
    public void boughtSeat(Seat seat) throws Exception{
        //isSeatValid(row, seatNumber);
        seat.setBought(true);
    }


    public void printAllSeats(){
        for(int i = 0; i < seats.length; i++){
            System.out.print("row " + (i+1) + ": ");
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j].isReserved())
                    System.out.print("[-] ");
                else if(seats[i][j].isBought())
                    System.out.print("[X] ");
                else
                    System.out.print("[" + (j+1) + "] ");
            }
            System.out.println();
        }
    }

    public boolean isSeatOccupied(int row, int seatNumber) throws Exception {
        isSeatValid(row, seatNumber);
        // true->occupied; false->free for reservation
        if(seats[row][seatNumber].isReserved() || seats[row][seatNumber].isBought())
            return true;
        return false;
        //return seats[row][seatNumber].isReserved() || seats[row][seatNumber].isBought();
    }

    public void isSeatValid(int row, int seatNumber) throws Exception{
        boolean rowValid = true;
        boolean seatValid = true;

        if(row < 0 || row > seats.length){
            rowValid = false;
        }
        if (seatNumber < 1 || seatNumber > seats[row].length) {
            seatValid = false;
        }
        if(!rowValid && !seatValid) throw new Exception("Invalid row and seat number!");
        if(!rowValid)throw new Exception("Invalid row number!");
        if(!seatValid) throw new Exception("Invalid seat number!");

    }

}
