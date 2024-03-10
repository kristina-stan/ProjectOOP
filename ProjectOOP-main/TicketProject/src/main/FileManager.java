package main;

import Clients.User;
import transport.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private Scanner scanner;
    private File file;

    private ArrayList<User> fileUserList;
    private ArrayList<Transport> fileTransportList;

    FileManager(ArrayList<User> userList, ArrayList<Transport> transportList){

        this.scanner = new Scanner(System.in);

        this.fileUserList = userList;
        this.fileTransportList = transportList;

    }


    public void writeUsersToFile(ArrayList<User> userList){

        System.out.println("File name: ");
        String filePath = scanner.nextLine();
        setFile(filePath);

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            for(User user : userList){
                oos.writeObject(user);
            }
            System.out.println("All users written to file: " + file.getName() + " successfully!");

        } catch (IOException e){
            System.out.println("Error writing users to file: " + file.getName());
        }

    }

    public ArrayList<User> readUsersFromFile(){

        System.out.println("File name: ");
        String filePath = scanner.nextLine();
        setFile(filePath);


        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)){

            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof User) {
                        User user = (User) obj;
                        fileUserList.add(user);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("All users read from" + file.getName() + " successfully!");

        }catch (ClassNotFoundException | IOException e){
            System.out.println("Error reading users from file: " + file.getName());
        }
        return fileUserList;
    }

    public void writeTransportsToFile(ArrayList<Transport> transportList){

        System.out.println("File name: ");
        String filePath = scanner.nextLine();
        setFile(filePath);

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            for(Transport transport : transportList){
                oos.writeObject(transport);
            }
            System.out.println("All users written to file: " + file.getName() + " successfully!");

        } catch (IOException e){
            System.out.println("Error writing users to file: " + file.getName());
        }

    }

    public ArrayList<Transport> readTransportsFromFile(){

        System.out.println("File name: ");
        String filePath = scanner.nextLine();
        setFile(filePath);


        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)){

            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Transport) {
                        Transport transport = (Transport) obj;
                        fileTransportList.add(transport);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("All users read from" + file.getName() + " successfully!");

        }catch (ClassNotFoundException | IOException e){
            System.out.println("Error reading users from file: " + file.getName());
        }
        return fileTransportList;
    }

    public void setFile(String filePath){
        this.file = new File(filePath);
    }

}
