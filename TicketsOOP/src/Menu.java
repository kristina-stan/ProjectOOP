import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ArrayList<Event> eventList;
    private ArrayList<Hall> hallsList;
    private ArrayList<Ticket> ticketList;

    Menu(ArrayList<Hall> hallsList, ArrayList<Event> eventList){
        this.scanner = new Scanner(System.in);
        this.eventList = eventList;
        this.hallsList = hallsList;
    }

    public void runMenu() throws Exception{

        System.out.print("> ");
        //String[] splitString = scanner.nextLine().split(" ");
        String command = scanner.nextLine();

        switch (command){
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
            case "freeseats":
                printSelectedEventSeats();
                break;
            case "book":
                bookTicket();
                break;
            case "unbook":
                break;
            case "buy":
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

    public void unbookTicket() throws Exception{

        int chosenRow = Integer.parseInt(scanner.nextLine());
        int chosenSeat = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.parse(scanner.nextLine());
        String eventName = scanner.nextLine();

        if(!areThereEvents()) return;
        for(Ticket ticket : ticketList){
            if(ticket.getEvent().getEventName().equals(eventName) &&
                    ticket.getEvent().getDate().equals(date)){
                ticket.setVisitorSeat(chosenRow,chosenSeat,false);
                ticketList.remove(ticket);
                return;
            }
        }
        System.out.println("Ticket not found!");
    }

    public void bookTicket() throws Exception{ // row,seat,date,nameEvent,note

        int chosenRow = Integer.parseInt(scanner.nextLine());
        int chosenSeat = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.parse(scanner.nextLine());
        String eventName = scanner.nextLine();
        String note = scanner.nextLine();

        if(!areThereEvents()) return;
        for(Event event : eventList){

            if(event.getDate().equals(date) && event.getEventName().equals(eventName)){

                Ticket newTicket = new Ticket(event, chosenRow, chosenSeat, note);
                ticketList.add(newTicket);
                return;
            }
        }
        System.out.println("Invalid date or event name!");
    }

    public void printSelectedEventSeats(){

        LocalDate date = LocalDate.parse(scanner.nextLine());
        String eventName = scanner.nextLine();

        if(!areThereEvents()) return;
        for(Event event : eventList){
            if(date.equals(event.getDate()) && eventName.equals(event.getEventName())){
                event.printEventSeats();
                return;
            }
        }
        System.out.println("Invalid date or event's name!");
    }

    public void addEvent() throws Exception{

        LocalDate date = LocalDate.parse(scanner.nextLine());
        int hallNumber = Integer.parseInt(scanner.nextLine());
        String eventName = scanner.nextLine();

        //check if the hall is free on <date>
        for(Event existingEvent : eventList){

            if(existingEvent.getDate().equals(date) &&
                    existingEvent.getHall().getHallNumber() == hallNumber){
                System.out.println("An event is already booked on the " + date.toString() +
                        " in hall " + hallNumber);
                return;
            }
        }
        // find hall with the wanted number
        for(Hall hall : hallsList) {
            if (hallNumber == hall.getHallNumber()) {
                eventList.add(new Event(date, hall, eventName));
                System.out.println("Event '" + eventName + "' added successfully for " +
                        date + " in hall " + hall);
            }
        }
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

    public boolean areThereEvents() {
        if (eventList.isEmpty()) {
            System.out.println("No events, Sorry!");
            return false;
        }
        return true;
    }

}
