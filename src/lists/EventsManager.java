package lists;

import utilitys.Event;
import utilitys.Hall;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventsManager implements EventManagementInterface{
    private ArrayList<Event> eventsList;

    public void addEvent(Hall hall, String name, String date) throws Exception{
        eventsList.add(new Event(hall,name,date));
    }

    public EventsManager(ArrayList<Event> eventsList) throws Exception{
        this.eventsList = eventsList;
    }

    public boolean isEmpty(){
        return eventsList.isEmpty();
    }

    public void setEventsList(ArrayList<Event> eventsList) {
        this.eventsList = eventsList;
    }
    public ArrayList<Event> getEventsList() {
        return eventsList;
    }

    @Override
    public Event searchEvent(String name, String date) {
        return null;
    }

    /*public Event searchEvent(String name, String date){
        for(Event searchedEvent : eventsList){
            if(searchedEvent.g().equals(date) && searchedEvent.getName().equals(name)){
                return searchedEvent;
            }
        }
        return null;
    }*/

    public boolean checkIsHallAvaliable(Hall hall, String date) throws Exception{
        for(Event event:eventsList){
            if(event.isMatching(hall) && event.isMatching(date)){
                return false; // if it matching it's occupied
            }
        }
        return true;
    }

}
