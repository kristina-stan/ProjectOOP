package lists;

import utilitys.Hall;

import java.util.ArrayList;

public interface HallManagementInterface {

    boolean isEmpty();
    public void setHallsList(ArrayList<Hall> hallsList);
    public ArrayList<Hall> getHallsList();
    public Hall getHallByNumber(int hallNumber);

}
