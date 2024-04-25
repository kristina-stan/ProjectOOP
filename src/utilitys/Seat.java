package utilitys;

public class Seat {

    private int row;
    private int seatNumber;
    private boolean isReserved;
    private boolean isBought;

    public Seat(int row, int seatNumber) throws Exception{

        setRow(row);
        setSeatNumber(seatNumber);
        setReserved(false);
        setBought(false);
    }


    // SETTERS
    public void setRow(int row) throws Exception{
        if(row <= 0) throw new Exception("Invalid row!");
        this.row = row;
    }
    public void setSeatNumber(int seatNumber) throws Exception{
        if(seatNumber <= 0) throw new Exception("Invalid seat number!");
        this.seatNumber = seatNumber;
    }
    public void setReserved(boolean reserved) {
        if(isBought) return;
        isReserved = reserved;
    }
    public void setBought(boolean bought){
        if(isReserved) return;
        isBought = bought;
    }

    // GETTERS
    public int getRow() {
        return row;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public boolean isReserved() {
        return isReserved;
    }
    public boolean isBought(){
        return isBought;
    }

    public boolean isMatchingSeat(int row, int seatNumber){
        if(this.row == row && this.seatNumber == seatNumber) return true;
        return false;
    }


}
