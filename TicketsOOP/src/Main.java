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

            Menu menu = new Menu(hallsList, eventsList);

            System.out.println("\nWELCOME TO THE THEATER!");

            while (true){
                menu.runMenu();
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}