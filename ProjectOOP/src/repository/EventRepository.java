package repository;

import entity.Event;
import entity.Hall;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventRepository {
    private ArrayList<Event> eventList;

    public EventRepository(ArrayList<Event> eventList){
        this.eventList = eventList;
    }

    public void addEvent(Event newEvent){
        this.eventList.add(newEvent);
        System.out.println("Event '" + newEvent.getEventName() + "' added successfully for " +
                newEvent.getDate() + " in hall " + newEvent.getEventHallNumber());
    }
    void removeEvent(Event removeEvent){
        this.eventList.remove(removeEvent);
    }

    ArrayList<Event> getEventList(){
        return eventList;
    }
    void setEventList(ArrayList<Event> eventList){
        this.eventList = eventList;
    }

    public boolean isEventListEmpty() {
        return eventList.isEmpty();
    }

    public Event searchEvent(LocalDate date, String eventName){
        for(Event event : eventList){
            if(event.getDate()==date && event.getEventName().equals(eventName))
                return event;
        }
        return null;
    }

    public boolean isHallAvaliable(LocalDate date, Hall hall){
        for(Event event : eventList){
            if(event.getDate().equals(date) && event.getHall()==hall)
                return false;
        }
        return true;
    }

}
