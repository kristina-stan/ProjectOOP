import lists.EventsManager;
import lists.HallsManager;
import lists.TicketsManager;
import tikets.BookedTicket;
import tikets.BoughtTicket;
import utilitys.DateManager;
import utilitys.Event;
import utilitys.Hall;
import utilitys.Seat;

import javax.swing.text.DateFormatter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ArrayList<Event> eventsList;
    private ArrayList<Hall> hallsList;
    private ArrayList<BookedTicket> bookedTickets;
    private ArrayList<BoughtTicket> boughtTickets;

    //private EventsManager em;
    //private HallsManager hm;
    //private TicketsManager tm;

    private String[] command;

    Menu(ArrayList<Event> eventsList, ArrayList<Hall> hallsList) throws Exception{

        scanner = new Scanner(System.in);
        this.eventsList = eventsList;
        this.hallsList = hallsList;
        this.bookedTickets = new ArrayList<>();
        this.boughtTickets = new ArrayList<>();

        //this.em = new EventsManager(eventsList);
        //this.hm = new HallsManager(hallsList);
        //this.tm = new TicketsManager(bookedTickets, boughtTickets);

    }

    public void runMenu() throws Exception{

        System.out.print("> ");
        String commandInput = scanner.nextLine();
        this.command = commandInput.split(" ");

        switch (command[0]){

            case "open":
                break;
            case "close":
                break;
            case "save":
                break;
            case "saveas":
                break;
            case "help": //READY
                helpMenu();
                break;
            case "exit": //READY
                exitProgram();
                break;
            case "addevent": //READY
                addEvent();
                break;
            case "freeseats":// READY
                printFreeSeats();
                break;
            case "book": //READY
                bookTicket();
                break;
            case "unbook": //READY
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
                throw new Exception(Arrays.toString(command) + " command not recognised.");
        }

    }

    public String eventNameJoin(int startPosition, int endPosition){
        String eventName = String.join(" ",
                Arrays.copyOfRange(command, startPosition, endPosition));
        return eventName;
    }

    public void addEvent() throws Exception{
        DateManager eventDate = new DateManager(command[1]);
        int hallNumber = Integer.parseInt(command[2]);
        String eventName = eventNameJoin(3, command.length);

        Hall hall = getHallByNumber(hallNumber);

        if(isEventsEmpty() || checkIsHallAvaliable(hall, eventDate)){
            eventsList.add(new Event(hall,eventName,eventDate));
            System.out.println("\"" + eventName + "\" is set on the " + eventDate + " in hall " + eventDate);
            return;
        }

        System.out.println("Sorry, hall " + hall.getNumber() +
                " is occupied on the " + eventDate);
    }

    public void printFreeSeats(){
        // prints unsold/nonbooked seats
        DateManager eventDate = new DateManager(command[1]);
        String eventName = eventNameJoin(2, command.length);

        // if no events, return
        if(isEventsEmpty()) return;

        // find event by Name & Date
        Event event = searchEvent(eventName,eventDate);
        if(event==null) return;
        event.printEventSeats(); // print free seats
    }

    public void bookTicket() throws Exception{ // book <row> <seat> <date> Reserves a ticket for a performance named <name> on <date> in row <row> and seat <seat>,\n" +
        int row = Integer.parseInt(command[1]);
        int seatNumber = Integer.parseInt(command[2]);
        DateManager eventDate = new DateManager(command[3]);
        String eventName = eventNameJoin(4,command.length);
        String note = "";

        //find event
        Event searchedEvent = searchEvent(eventName, eventDate);

        //check is seat free
        if(searchedEvent.getHall().getSeats().isSeatOccupied(row-1,seatNumber-1)){
            System.out.println("The seat on row " + row + " seat number " + seatNumber
                    + " is occupied. Please choose another seat!");
            return;
        }
        //add booked ticket
        bookedTickets.add(new BookedTicket(searchedEvent, row-1, seatNumber-1, note));
        System.out.println("Booked ticket on the " + eventDate.dateToString() + " for the \""
                + eventName + "\". Row " + row + ", Seat " + seatNumber);

    }

    public void unbookTicket() throws Exception{
        int row = Integer.parseInt(command[1]);
        int seatNumber = Integer.parseInt(command[2]);
        DateManager eventDate = new DateManager(command[3]);
        String eventName = eventNameJoin(4,command.length);

        // find booked ticket
        BookedTicket searchedTicket = findTicket(row-1, seatNumber-1, eventName, eventDate);
        if(searchedTicket == null) return;

        // remove ticket
        searchedTicket.getReservedSeat().setReserved(false);
        bookedTickets.remove(searchedTicket);
        System.out.println("Unbooking of the ticket for " + eventName + " on the " + eventDate.dateToString()
                + " on row " + row + ", seat " + seatNumber + " is successful!");

    }

    public void buyTicket() throws Exception{
        int row = Integer.parseInt(command[1]);
        int seatNumber = Integer.parseInt(command[2]);
        DateManager eventDate = new DateManager(command[3]);
        String eventName = eventNameJoin(4,command.length);

        // find event
        Event searchedEvent = searchEvent(eventName,eventDate);

        //check is seat free
        if(searchedEvent.getHall().getSeats().isSeatOccupied(row-1,seatNumber-1)){
            System.out.println("The seat on row " + row + " seat number " + seatNumber + " is occupied."
                    + "Please choose another seat!");
            return;
        }
        //add booked ticket
        boughtTickets.add(new BoughtTicket(searchedEvent, row-1, seatNumber-1));
        System.out.println("Bought ticket on the " + eventDate.dateToString() + " for the \"" + eventName
                + "\".Row " + row + ", seat " + seatNumber);



    }

    public BookedTicket findTicket(int row, int seat, String eventName, DateManager date) throws Exception{

        // find seat and event that match
        for(BookedTicket ticket : bookedTickets){
            if(ticket.isMatchingSeat(row,seat) && ticket.isMatchingEvent(searchEvent(eventName,date)))
                return ticket;
        }
        System.out.println("Ticket not found!");
        return null;
    }

    public Hall getHallByNumber(int hallNumber){
        for(Hall hall : hallsList){
            if(hall.getNumber() == hallNumber){
                return hall;
            }
        }
        return null;
    }
    public boolean isEventsEmpty(){
        return eventsList.isEmpty();
    }
    public boolean checkIsHallAvaliable(Hall hall, DateManager date){
        for(Event event:eventsList){
            if(event.isMatching(hall) && event.isMatching(date)){
                return false; // if it matching it's occupied
            }
        }
        return true;
    }
    public Event searchEvent(String eventName, DateManager eventDate){
        for(Event event : eventsList){
            if(event.isMatching(eventDate) && event.isMatching(eventName))
                return event;
        }
        System.out.println("Event not found!");
        return null;
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
