package main;

import Clients.User;
import transport.Transport;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Transport> transports = new ArrayList<>();

        Menu menu = new Menu(users, transports);
        menu.startMenu();
    }
}
