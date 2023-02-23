package com.brideglabz.addressbookfileio;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBookMain {
    static AddressBookMain addressBook = new AddressBookMain();
    Scanner sc = new Scanner(System.in);
    String searchByName;
    static int option;
    static Contacts contact;
    static ArrayList <Contacts> contacts = new ArrayList<Contacts>(); //using Arraylist as it is easier than using Array
    public void CreatingContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the contact details");
        System.out.println("Enter the first name");
        String f_name = sc.next();
        System.out.println("Enter the last name");
        String l_name = sc.next();
        System.out.println("Enter the address line without spaces");
        String address  = sc.next();
        System.out.println("Enter the city name");
        String city  = sc.next();
        System.out.println("Enter the state name");
        String state = sc.next();
        System.out.println("Enter the Zip code");
        String zip = sc.next();
        System.out.println("Enter the phone number");
        String ph_no = sc.next();
        System.out.println("Enter the email address");
        String email = sc.next();
        System.out.println("Contact created");
        contact = new Contacts(f_name,l_name,address,city,state,zip,ph_no,email);
    }
    public void addingContacts() {
        contacts.add(contact);
    }
    public void editContacts() {
        if(contacts.get(0).getF_name().equalsIgnoreCase(searchByName)) {
            System.out.println("Enter respectively\n1.First name 2.Last name 3.Address" +
                    " 4.City 5.State 6.Zip 7.Phone number 8.Email address");
            int option2 = sc.nextInt();
            switch (option2) {
                case 1:
                    System.out.println("Enter the first name to be edited");
                    contacts.get(0).setF_name(sc.next());
                    break;
                case 2:
                    System.out.println("Enter the last name to be edited");
                    contacts.get(0).setL_name(sc.next());
                    break;
                case 3:
                    System.out.println("Enter the address to be edited");
                    contacts.get(0).setAddress(sc.next());
                    break;
                case 4:
                    System.out.println("Enter the city name to be edited");
                    contacts.get(0).setCity(sc.next());
                    break;
                case 5:
                    System.out.println("Enter the state name to be edited");
                    contacts.get(0).setState(sc.next());
                    break;
                case 6:
                    System.out.println("Enter the zip code to be edited");
                    contacts.get(0).setZip(sc.next());
                    break;
                case 7:
                    System.out.println("Enter the phone number to be edited");
                    contacts.get(0).setPh_no(sc.next());
                    break;
                case 8:
                    System.out.println("Enter the email address to be edited");
                    contacts.get(0).setEmail(sc.next());
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        else
            System.out.println("Oops! can't find the name");
    }
    public void menu() {
        System.out.println("Menu: (Enter the respective number)\n1. Add contact 2. Edit contact 3. Display");
        option = sc.nextInt();
        switch(option) {
            case 1:
                addressBook.CreatingContact();
                addressBook.addingContacts();
                addressBook.menu();
                break;
            case 2:
                System.out.println("Enter the first name to search and edit contact with first name");
                searchByName = sc.next();
                addressBook.editContacts();
                addressBook.menu();
                break;
            case 3:
                System.out.println(contacts.get(0));
                addressBook.menu();
            default:
                System.out.println("Invalid option");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to day 9 address book program");
        addressBook.menu();
    }
}
