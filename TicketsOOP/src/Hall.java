public class Hall {

    private int hallNumber;
    private Seat[][] hallSeats;


    public Hall(int hallNumber, int rows, int seatsPerRow){

        setHallNumber(hallNumber);
        setHallSeats(rows, seatsPerRow);

    }

    public void checkFreeSeats(int checkSeat){

    }

    public void printHallSeats(){

        System.out.println("HALL 1");
        System.out.println("The free seats are numbered");

        int rowNumber = 1;

        for(Seat[] rowSeats : hallSeats){
            System.out.print("row " + rowNumber + ": ");
            for(Seat seat : rowSeats){
                if(seat.isReserved())
                    System.out.print("[-] ");
                else
                    System.out.print("[" + seat.getSeatNumber() + "] ");
            }
            System.out.println();
            rowNumber++;
        }
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
    public void setHallSeats(int row, int seat) {
        this.hallSeats = new Seat[row][seat];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < seat; j++){
                Seat newSeat = new Seat(i+1, j+1); // crete new seat
                hallSeats[i][j] = newSeat; // add created seat
            }
        }
    }
    public void setSeatStatus(int row, int seat, boolean status){
        hallSeats[row][seat].setReserved(status);
    }

    public int getHallNumber() {
        return hallNumber;
    }
    public Seat[][] getAllHallSeats() {
        return hallSeats;
    }
}

