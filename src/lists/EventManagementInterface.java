package lists;

import utilitys.Event;

import java.util.ArrayList;

public interface EventManagementInterface {

    boolean isEmpty();
    void setEventsList(ArrayList<Event> eventsList);
    public ArrayList<Event> getEventsList();

    public Event searchEvent(String name, String date);


}
