<<<<<<< HEAD
import entity.Event;
import entity.Hall;
import tickets.BookedTicket;
import tickets.BoughtTicket;

import java.time.LocalDate;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        try {

            ArrayList<Hall> hallsList = new ArrayList<Hall>();
            hallsList.add(new Hall(1, 10,23));
            hallsList.add(new Hall(2, 6, 16));

            ArrayList<Event> eventsList = new ArrayList<Event>();
            eventsList.add(new Event(LocalDate.parse("2023-10-23"),hallsList.get(0), "Friday night"));
            eventsList.add(new Event(LocalDate.parse("2023-03-16"),hallsList.get(1), "Sunday morning"));

            ArrayList<BookedTicket> bookedTickets = null;
            ArrayList<BoughtTicket> boughtTickets = null;

            Menu menu = new Menu(eventsList, hallsList, bookedTickets, boughtTickets);

            System.out.println("\nWELCOME TO THE THEATER!");

            while (true){
                menu.runMenu();
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
=======
import tikets.BookedTicket;
import tikets.BoughtTicket;
import tikets.Ticket;
import utilitys.Event;
import utilitys.Hall;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Hall> hallsList = new ArrayList<Hall>();
        ArrayList<Event> eventList = new ArrayList<Event>();
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        ArrayList<BookedTicket> bookedTickets = new ArrayList<BookedTicket>();
        ArrayList<BoughtTicket> boughtTickets = new ArrayList<BoughtTicket>();

        Hall hall1 = new Hall(1,10,23);
        Hall hall2 = new Hall(2,5,15);
        Hall hall3 = new Hall(3,7,20);

        Menu menu = null;

        try {
            hallsList.add(hall1);
            hallsList.add(hall2);
            hallsList.add(hall3);
            eventList.add(new Event(hall1, "Sunday morning", "2023-10-10"));
            eventList.add(new Event(hall1, "Collin's house", "2023-10-23"));

            menu = new Menu(eventList, hallsList, bookedTickets, boughtTickets);
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
>>>>>>> kristina-stan-patch-7
}