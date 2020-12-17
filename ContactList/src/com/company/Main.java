package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    //create mobile phone class
    private static MobilePhone mobilePhone = new MobilePhone("0625788585");

    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        startPhone();
        printAction();
        while(!quit){
            System.out.println("\nEnter action 6: (to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\n Shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printAction();
                    break;


            }

        }
    }

    private static void startPhone(){
        System.out.println("Phone is starting...");
    }

    private static void printAction(){
        System.out.println("\n Available actions \n Press");
        System.out.println("0 - To shut down\n" +
                            "1 - To print actions\n "+
                            "2 - To add a new contact\n" +
                            "3 - To update an existing contact\n" +
                            "4 - To remove an existing contact\n" +
                            "5 - To query if an existing contact exists\n" +
                            "6 - To print a list of available actions");
        System.out.println("Choose your action");
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber);
        if (mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added " + name + " ," + phoneNumber);
        }
        else {
            System.out.println("Cannot add " + name + " already on file");
        }
    }

    public static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if (mobilePhone.updateContact(existingContact,newContact)){
            System.out.println("Success");
        }
    }

    public static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        mobilePhone.removeContact(existingContact);
    }

    public static void queryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + " Phone number is " + existingContact.getNumber());
        }
}
