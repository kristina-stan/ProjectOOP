package repository;

import entity.Hall;

import java.util.ArrayList;

public class HallRepository {

    private ArrayList<Hall> hallList;

    public HallRepository(ArrayList<Hall> hallList){
        this.hallList = hallList;
    }

    ArrayList<Hall> getHallList(){
        return this.hallList;
    }
    void setHallList(ArrayList<Hall> hallList){
        this.hallList = hallList;
    }

    public Hall searchHall(int hallNumber){
        for (Hall hall : hallList){
            if(hall.getHallNumber()==hallNumber)
                return hall;
        }
        System.out.println("Invalid hall number");
        return null;
    }


}
