import tikets.BookedTicket;
import tikets.BoughtTicket;
import tikets.Ticket;
import utilitys.DateManager;
import utilitys.Event;
import utilitys.Hall;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Hall> hallsList = new ArrayList<Hall>();
        ArrayList<Event> eventList = new ArrayList<Event>();

        Hall hall1 = new Hall(1,10,23);
        Hall hall2 = new Hall(2,5,15);
        Hall hall3 = new Hall(3,7,20);

        Menu menu = null;

        try {
            hallsList.add(hall1);
            hallsList.add(hall2);
            hallsList.add(hall3);
            eventList.add(new Event(hall1, "Sunday morning", new DateManager("2025-10-10")));
            eventList.add(new Event(hall1, "Collin's house", new DateManager("2025-10-23")));

            menu = new Menu(eventList, hallsList);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("WELCOME TO THE THEATER!");

        while (true) {
            try {
                menu.runMenu();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}