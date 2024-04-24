package utilitys;


public class AllSeats {

    private Seat[][] seats;

    AllSeats(int rows, int seatsPerRow) throws Exception{
        seats = new Seat[rows][seatsPerRow];
        initializeSeats();
    }

    public void initializeSeats() throws Exception{
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                seats[i][j] = new Seat(i+1,j+1);
            }
        }
    }

    public Seat getSeat(int row, int seatNumber) throws Exception{
        isSeatValid(row, seatNumber);
        return seats[row-1][seatNumber-1];
    }

    // Change seat status
    public void reserveSeat(int row, int seatNumber) throws Exception{
        isSeatValid(row, seatNumber);
        seats[row-1][seatNumber-1].setReserved(true);
    }
    public void unreserveSeat(int row, int seatNumber) throws Exception{
        isSeatValid(row, seatNumber);
        seats[row-1][seatNumber-1].setReserved(false);
    }

    public void printAllSeats(){
        for(int i = 0; i < seats.length; i++){
            System.out.print("row " + (i+1) + ": ");
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j].isReserved())
                    System.out.print("[X] ");
                else
                    System.out.print("[" + (j+1) + "] ");
            }
            System.out.println();
        }
    }

    public boolean isSeatReserved(int row, int seatNumber) throws Exception {
        isSeatValid(row, seatNumber);
        return seats[row][seatNumber].isReserved(); // true->occupied; false->free for reservation
    }


    public void isSeatValid(int row, int seatNumber) throws Exception{

        if (row < 1 || row > seats.length) {
            throw new Exception("Invalid row number!");
        }
        if (seatNumber < 1 || seatNumber > seats[row - 1].length) {
            throw new Exception("Invalid seat number number!");
        }
    }

}
