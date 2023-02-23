package com.brideglabz.addressbookfileio;
import java.util.Scanner;
public class AddressBookMain extends AddressBook {
    static int option;
    public static void menu() {
        AddressBookMain addressBook = new AddressBookMain();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu: (Enter the respective number)\n1. Add contact 2. Edit contact 3. Delete 4. Display 5. Search by City or State 6. Count of person in city or state 7. Dictionary of person by city and state 8. Sort by 9. Exit");
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
                System.out.println("1. Search by city 2. Search by state");
                int option2 = sc.nextInt();
                if(option2 == 1) {
                    System.out.println("Enter the city name to search");
                    String citySearch = sc.next();
                    addressBook.searchByCity(citySearch).forEach(x -> System.out.println(x));
                }
                else if(option2 == 2) {
                    System.out.println("Enter the state name to search");
                    String stateSearch = sc.next();
                    addressBook.searchByState(stateSearch).forEach(x -> System.out.println(x));
                }
                menu();
                break;
            case 6:
                System.out.println("1. count of city 2. Search of state");
                int option3 = sc.nextInt();
                if(option3 == 1) {
                    System.out.println("Enter the city name");
                    String citySearch = sc.next();
                    addressBook.countByCity(citySearch);
                }
                else if(option3 == 2) {
                    System.out.println("Enter the state name");
                    String stateSearch = sc.next();
                    addressBook.countByState(stateSearch);
                }
                menu();
                break;
            case 7:
                System.out.println("1. dictionary of city and it's persons 2. dictionary of state and it's persons");
                int option4 = sc.nextInt();
                if(option4 == 1) {
                    System.out.println("Enter the city name");
                    String cityPerson = sc.next();
                    addressBook.dictionaryOfPersonByCity(cityPerson);
                }
                else if(option4 == 2) {
                    System.out.println("Enter the state name");
                    String StatePerson = sc.next();
                    addressBook.dictionaryOfPersonByState(StatePerson);
                }
                menu();
                break;
            case 8:
                System.out.println("1. Sort by name 2. Sort by city 3. Sort by state 4. Sort by zip");
                int option5 = sc.nextInt();
                if(option5 == 1)
                    addressBook.sortByName();
                else if (option5 == 2) {
                    addressBook.sortByCity();
                }
                else if (option5 == 3) {
                    addressBook.sortByState();
                }
                else if (option5 == 4) {
                    addressBook.sortByZip();
                }
                else
                    System.out.println("Invalid option");
                break;
            case 9:
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
