package utilitys;

public class Hall {

    private int number;
    private int rows;
    private int seatsPerRow;

    public Hall(int number, int rows, int seatsPerRow) {
        setNumber(number);
        setRows(rows);
        setSeatsPerRow(seatsPerRow);
    }

    public void setNumber(int number){
        this.number = number;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public int getNumber() {
        return number;
    }
    public int getRows() {
        return rows;
    }
    public int getSeatsPerRow() {
        return seatsPerRow;
    }
}
