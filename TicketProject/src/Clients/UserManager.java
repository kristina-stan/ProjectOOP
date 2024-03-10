package Clients;

import java.util.ArrayList;
import java.util.Scanner;

public interface UserManager {

    static boolean checkIsRegistered(ArrayList<User> passengers,
                                     String userInput, String userPassword){
        boolean user = false;
        boolean password = false;

        for(User passenger : passengers){
            if (passenger.getEmail().equals(userInput) || passenger.getUserName().equals(userInput))
                user = true;
            else if(passenger.getPassword().equals(userPassword))
                password = true;
            if(user && password) return true;
        }
        if(!user)
            System.out.println("Invalid email or user name!");
        if(!password)
            System.out.println("Invalid password!");
        return false;
    }

    static void login(ArrayList<User> passengers, Scanner scanner){

        System.out.println("Email or User name: ");
        String userInput = scanner.nextLine();
        System.out.println("Password: ");
        String userPassword = scanner.nextLine();

        if(checkIsRegistered(passengers, userInput, userPassword))
            //novo menu za users


    }

    static void singup(Scanner scanner){

        // user info username, password, email, phoneNumber, name(fist, last), age, sex
        System.out.println("First and Last name: ");
        String name = scanner.nextLine();
        System.out.println("User name: ");
        String userName = scanner.nextLine();
        System.out.println("E-mail: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Phone number: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Sex (M for male, F for Female): ");
        char sex = scanner.nextLine().charAt(0);

        // create new user
        try {
            User user = new User(name, age, sex, userName, password, email, phoneNumber);
        }catch (Exception e){
            System.out.println(e);
        }
        // show user menu

    }

}
