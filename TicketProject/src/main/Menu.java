package main;

import Clients.User;
import Clients.UserManager;
import ticket.TicketManager;
import transport.TransportManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements TicketManager, UserManager, TransportManager {

    ArrayList<User> passengers;
    ArrayList<TransportManager> transports;

    Menu(ArrayList<User> passengers, ArrayList<TransportManager> transports){
        this.passengers = passengers;
        this.transports = transports;
    }

    public void startMenu(Scanner scanner) {

        String option = scanner.nextLine().toLowerCase();

        switch (option) {
            case "open":
                break;

            case "close":
                break;

            case "save":
                break;

            case "save as":
                break;

            case "help":

                break;

            case "exit":
                break;

            case "login":
                UserManager.login(getPassengers, scanner);
                break;

            case "sign up":
                UserManager.singup(scanner);
                break;

            case "buy ticket":
                buyTicket();
                break;


        }

    }


    public static void buyTicket(){

    }

    public static void helpInstructions() {
        System.out.println(">help\nThe following commands are supported:");
        System.out.println("Open - Зарежда съдържанието на файл, ако го няма се създава.");
        System.out.println("Close - Затваря файла и изчиства текущо заредената информация.");
        System.out.println("Save - Записва промените в същият файл.");
        System.out.println("Save as - Записва промените в избран от потребителя файл.");
        System.out.println("Help - Short information about the commands of the program.");
        System.out.println("Login - ");
        System.out.println("Sing up - ");
        System.out.println("Buy ticket - ");
        System.out.println("Exit - ");

    }

    public ArrayList<User> getPassengers() {
        return passengers;
    }
}
