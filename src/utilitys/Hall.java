package utilitys;

public class Hall {

    private int number;
    private AllSeats seats;
    private int capacity;
    //private int rows;
    //private int seatsPerRow;

    public Hall(int number, int rows, int seatsPerRow) {
        setNumber(number);
        setSeats(rows,seatsPerRow);
        setCapacity(rows,seatsPerRow);
        //setRows(rows);
        //setSeatsPerRow(seatsPerRow);
    }

    public void setCapacity(int rows, int seatsPerRow){
        this.capacity = rows*seatsPerRow;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setNumber(int number){
        this.number = number;
    }

    public void setSeats(int rows, int seatsPerRow) {
        try{
            this.seats = new AllSeats(rows, seatsPerRow);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*public void setRows(int rows) {
        this.rows = rows;
    }
    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }*/

    public int getNumber() {
        return number;
    }
    public AllSeats getSeats() {
        return seats;
    }

    /*public int getRows() {
        return rows;
    }
    public int getSeatsPerRow() {
        return seatsPerRow;
    }*/
}
