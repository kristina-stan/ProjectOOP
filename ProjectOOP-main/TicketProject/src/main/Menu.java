package main;

import Clients.User;
import transport.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private FileManager fm;

    private ArrayList<User> userList;
    private ArrayList<Transport> transportList;
    private User currentUser;

    Menu(ArrayList<User> userList, ArrayList<Transport> transportList){

        scanner = new Scanner(System.in);

        this.userList = userList;
        this.transportList = transportList;

        fm = new FileManager(userList,transportList);
    }
    
    public void startMenu (){

        String option = scanner.nextLine().toLowerCase();
        while(true) {
            switch (option) {

                case "open":
                    readFromFiles();
                    break;
                case "close":
                    writeToFiles();
                    break;
                case "save":
                    break;
                case "save as":
                    break;
                case "help":
                    break;
                case "exit":
                    exitApplication();
                    break;
                case "login":
                    userLogIn();
                    break;
                case "sign up":
                    userSingUp();
                    break;
                case "buy ticket":
                    //buyTicket();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;

            }
        }
    }

    public void userSingUp(){

       while(true) {
           try { // userName, password, passwordCheck, FistName, LastName(combined in name), age, gander(M/F), emial, phonenNumber

               System.out.print("User name: ");
               String userName = scanner.nextLine();
               System.out.println("Password: ");
               String password = scanner.nextLine();
               //System.out.print("Password verification: ");
               System.out.print("First name: ");
               String name = scanner.nextLine();
               System.out.print("Last name: ");
               name.concat(scanner.nextLine());
               System.out.print("Age: ");
               int age = Integer.parseInt(scanner.nextLine());
               System.out.print("Gender: ");
               char gender = scanner.nextLine().charAt(0);
               System.out.print("E-mail: ");
               String email = scanner.nextLine();
               System.out.print("Phone number: ");
               String phoneNumber = scanner.nextLine();

               User.signUp(name,age,gender,userName,password,email,phoneNumber);

               break;

           } catch (Exception e) {
               System.out.println(e);
           }
       }
    }

    public void userLogIn(){

        System.out.println("E-mail or user name: ");
        String userName = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        for(User user : userList) {
            if (user.existingUser(userName, password)) {
                System.out.println("Logging in successful!");
                currentUser = user;
                return;
            }
        }
        System.out.println("Invalid password or e-mail/user name!");
    }

    public void readFromFiles(){
        
        userList = fm.readUsersFromFile();
        transportList = fm.readTransportsFromFile();
    }

    public void writeToFiles(){

        fm.writeUsersToFile(userList);
        fm.writeTransportsToFile(transportList);
    }






    public void exitApplication(){
        System.out.println("Exiting...");
        System.exit(0);
    }

}
