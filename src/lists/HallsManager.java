package lists;

import utilitys.Hall;

import java.util.ArrayList;

public class HallsManager implements HallManagementInterface{

    private ArrayList<Hall> hallsList;

    public HallsManager(ArrayList<Hall> hallsList){
        this.hallsList = hallsList;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void setHallsList(ArrayList<Hall> hallsList) {
        this.hallsList = hallsList;
    }

    public ArrayList<Hall> getHallsList() {
        return hallsList;
    }
    public Hall getHallByNumber(int hallNumber){
        for(Hall hall : hallsList){
            if(hall.getNumber()==hallNumber)
                return hall;
        }
        return null;
    }

}
