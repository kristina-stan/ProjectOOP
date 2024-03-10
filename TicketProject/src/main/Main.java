package main;

import Clients.Passenger;
import Clients.UserManager;
import transport.Transport;
import transport.TransportManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList<UserManager> passengers = new ArrayList<UserManager>();
        ArrayList<TransportManager> transports = new ArrayList<TransportManager>();

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        menu.startMenu(scanner);
    }
}
