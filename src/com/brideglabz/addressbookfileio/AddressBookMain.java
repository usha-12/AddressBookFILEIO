package com.brideglabz.addressbookfileio;
import java.util.Scanner;
public class AddressBookMain extends AddressBook {
    static int option;
    public static void menu() {
        AddressBookMain addressBook = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu: (Enter the respective number)\n1. Add contact 2. Edit contact 3. Delete 4. Display 5.Exit");
        option = sc.nextInt();
        switch(option) {
            case 1:
                addressBook.creatingContact();
                addressBook.addingContacts();
                addressBook.menu();
                break;
            case 2:
                System.out.println("Enter the first name to search and edit contact with first name");
                addressBook.searchByName = sc.next();
                addressBook.editContacts();
                addressBook.menu();
                break;
            case 3:
                System.out.println("Enter the first name to search and edit contact with first name");
                addressBook.searchByName = sc.next();
                addressBook.deleteContact();
                addressBook.menu();
            case 4:
                System.out.println("Enter the contact's first name to display");
                addressBook.searchByName = sc.next();
                for(int i = 0; i < contacts.size(); i++) {
                    if(contacts.get(i).getF_name().equalsIgnoreCase(addressBook.searchByName)) {
                        System.out.println(contacts.get(i));
                        addressBook.menu();
                    }
                    else {
                        System.out.println("Oops, can't found the name. Try again");
                        addressBook.menu();
                    }
                }
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid option");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to day 9 address book program");
        AddressBookMain.menu();
    }
}
