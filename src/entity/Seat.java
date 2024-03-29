package entity;

public class Seat {

    private int seatNumber;
    private int row;
    private boolean isReserved;

    public Seat(int row, int seatNumber){

        setSeatNumber(seatNumber);
        setRow(row);
        setReserved(false);

    }

    // [number]-free seat; []-booked seat
    public void printSeatInfo(){
        System.out.println("row " + this.row + ": ");
    }


    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public int getRowSeat() {
        return row;
    }
    public boolean isReserved() {
        return isReserved;
    }

}
