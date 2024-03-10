package transport;

public class Train extends Transport{

    private int[] wagonNumber;
    private String[] tClass = new String[3];

    Train(String route, int numberSeats, int numberWagons) throws Exception{
        super(route, numberSeats);
        this.wagonNumber = new int [numberWagons];
        settClass();
    }

    public void settClass() {
        tClass[0] = "1";
        tClass[1] = "2";
        tClass[2] = "sleep";
    }
}
