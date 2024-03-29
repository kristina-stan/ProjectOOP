import entity.*;
import repository.*;
import tickets.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ArrayList<Event> eventList;
    private ArrayList<Hall> hallsList;
    private ArrayList<BookedTicket> bookedTickets;
    private ArrayList<BoughtTicket> boughtTickets;
    private HallRepository hr;
    private EventRepository er;
    private TicketRepository tr;
    private String[] command;


    Menu(ArrayList<Event> eventList, ArrayList<Hall> hallsList,
         ArrayList<BookedTicket> bookedTickets, ArrayList<BoughtTicket> boughtTickets){
        this.scanner = new Scanner(System.in);
        this.eventList = eventList;
        this.hallsList = hallsList;
        this.bookedTickets = bookedTickets;
        this.boughtTickets = boughtTickets;
        this.hr = new HallRepository(hallsList);
        this.er = new EventRepository(eventList);
        this.tr = new TicketRepository(bookedTickets, boughtTickets);
    }

    public void runMenu() throws Exception{

        System.out.print("> ");
        command = (scanner.nextLine()).split(" ");

        switch (command[0]){
            case "open":
                break;
            case "close":
                break;
            case "save":
                break;
            case "saveas":
                break;
            case "help":
                helpMenu();
                break;
            case "exit":
                exitProgram();
                break;
            case "addevent":
                addEvent();
                break;
            case "freeseats": // READY
                printFreeSeats();
                break;
            case "book":
                bookTicket();
                break;
            case "unbook":
                unbookTicket();
                break;
            case "buy":
                buyTicket();
                break;
            case "booking":
                break;
            case "check":
                break;
            case "report":
                break;
            default:
                System.out.println(command + " command not recognised.");
        }

    }


    public void bookings(){
    }

    public void unbookTicket(){

        int chosenRow = Integer.parseInt(command[1]);
        int chosenSeat = Integer.parseInt(command[2]);
        LocalDate date = LocalDate.parse(command[3]);
        String eventName = command[4];

        if(er.isEventListEmpty()) return;

        System.out.println("Ticket not found!");
    }

    public void bookTicket() throws Exception{ // row,seat,date,nameEvent,note

        int chosenRow = Integer.parseInt(command[1]);
        int chosenSeat = Integer.parseInt(command[2]);
        LocalDate date = LocalDate.parse(command[3]);
        String note = command[4];

        // return if empty
        if(er.isEventListEmpty()) return;

        // find event and BOOK TICKET
        //tr.findAndBookTicket(chosenRow, chosenSeat, date, eventName, note);

    }

    public void buyTicket() throws Exception{ // row,seat,date,nameEvent,note

        int chosenRow = Integer.parseInt(command[1]);
        int chosenSeat = Integer.parseInt(command[2]);
        LocalDate date = LocalDate.parse(command[3]);
        String eventName = command[4];

        if(er.isEventListEmpty()) return;

        Event searchedEvent = er.searchEvent(date, eventName);
        if(searchedEvent != null){
            BoughtTicket newTicket = new BoughtTicket(searchedEvent, chosenRow, chosenSeat);
            boughtTickets.add(newTicket);
            return;
        }
        System.out.println("Event not found!");
    }

    // freeseats
    public void printFreeSeats(){

        LocalDate eventDate = LocalDate.parse(command[1]);
        String eventName = command[2];

        // if no events, return
        if(er.isEventListEmpty()) return;

        // find event by Name & Date
        Event event = er.searchEvent(eventDate,eventName);
        event.printEventSeats(); // print free seats
    }

    //addevent
    public void addEvent() throws Exception{

        LocalDate targetDate = LocalDate.parse(command[1]);
        int targetHallNumber = Integer.parseInt(command[2]);
        String eventName = command[3];

        // search inputed hall
        Hall targetHall = hr.searchHall(targetHallNumber);
        if(targetHall == null){
            System.out.println("Invalid hall number.");
        }

        // if empty then ADD EVENT
        if(er.isEventListEmpty())
            er.addEvent(new Event(targetDate,targetHall,eventName));

        //check if hall is available
        if(!er.isHallAvaliable(targetDate,targetHall)) return;
        // if hall is free ADD EVENT
        er.addEvent(new Event(targetDate,targetHall,eventName));
    }

    public void helpMenu(){
        System.out.println("The following commands are supported:\n" +
                "open <file>                             Loads the content of a file. If it does't exit create an empty one\n" +
                "close                                   Closes the current open file and stops accepting other commands.\n" +
                "save                                    Writes the changes made back to the same file from which the data was read.\n" +
                "saveas                                  Saves the changes made to a file, allowing the user to specify its path.\n" +
                "help                                    Displays brief information about the commands supported by the program.\n" +
                "exit                                    Exits the program.\n" +
                "addevent <date> <hall> <name>           Adds a new performance on date <date> with name <name> in hall <hall>.\n" +
                "freeseats <date> <name>                 Returns a lookup of available seats for a performance named <name> on date <date>.\n" +
                "book <row> <seat> <date>                Reserves a ticket for a performance named <name> on <date> in row <row> and seat <seat>,\n" +
                "<name> <note>                           adding a note <note>.\n" +
                "unbook <row> <seat> <date>              Cancels a reservation for a performance named <name> on <date> on row <row> and seat <seat>.\n" +
                "<name>\n" +
                "buy <row> <seat> <date> <name>          Purchases a ticket for a performance named <name> on <date> in row <row> and seat <seat>.\n" +
                "booking [<date>][<name>]                Returns a list of reserved but unpaid or unpurchased tickets for a \n" +
                "                                        performance named <name> on <date>.\n" +
                "check <code>                            Performs a ticket validity check with the ticket code.\n" +
                "report <from> <to> [<hall>]             Returns a list of purchased tickets from date <from> to date <to> in hall <hall>.\n");

    }

    public void exitProgram(){
        System.out.println("Exiting the program...");
        System.exit(0);
    }

}
