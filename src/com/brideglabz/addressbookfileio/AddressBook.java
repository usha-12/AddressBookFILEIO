package com.brideglabz.addressbookfileio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class AddressBook {
    Scanner sc = new Scanner(System.in);
    String searchByName;
    static Contacts contact;
    int count = 1;
    static ArrayList<Contacts> contacts = new ArrayList<Contacts>(); //using collection as per the requirement of uc7
    static List<Contacts> duplicateCheckedcontacts;
    static List<Contacts> searchByCity;
    static List<Contacts> searchByState;

    public void creatingContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the contact details");
        System.out.println("Enter the first name");
        String f_name = sc.next();
        System.out.println("Enter the last name");
        String l_name = sc.next();
        System.out.println("Enter the address line without spaces");
        String address = sc.next();
        System.out.println("Enter the city name");
        String city = sc.next();
        System.out.println("Enter the state name");
        String state = sc.next();
        System.out.println("Enter the Zip code");
        String zip = sc.next();
        System.out.println("Enter the phone number");
        String ph_no = sc.next();
        System.out.println("Enter the email address");
        String email = sc.next();
        System.out.println("Contact created");
        contact = new Contacts(count, f_name, l_name, address, city, state, zip, ph_no, email);
    }

    public void addingContacts() {
        //this is for initial adding we have to make sure the list is not empty
        if (contacts.isEmpty()) {
            count++;
            contacts.add(contact);
        } else {//used streams to collect the duplicates alone in a separate list
            duplicateCheckedcontacts = contacts.stream().filter(x -> (x.getF_name() + x.getL_name()).equalsIgnoreCase(contact.getF_name() + contact.getL_name())).collect(Collectors.toList());
            //if the duplicate list has items in the contacts list sys out that there duplicate
            if (contacts.equals(duplicateCheckedcontacts)) {
                System.out.println("Found a duplicate contact " + contact.getF_name() + " " + contact.getL_name() + " Already exists S.no " + contact.getCount());
            }
            //else ther is no duplicate it will get added
            else {
                count++;
                contacts.add(contact);
            }
        }
    }

    public void editContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getF_name().equalsIgnoreCase(searchByName)) {
                System.out.println("Enter respectively\n1.First name 2.Last name 3.Address" +
                        " 4.City 5.State 6.Zip 7.Phone number 8.Email address");
                int option2 = sc.nextInt();
                switch (option2) {
                    case 1:
                        System.out.println("Enter the first name to be edited");
                        contacts.get(i).setF_name(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter the last name to be edited");
                        contacts.get(i).setL_name(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter the address to be edited");
                        contacts.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the city name to be edited");
                        contacts.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter the state name to be edited");
                        contacts.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter the zip code to be edited");
                        contacts.get(i).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter the phone number to be edited");
                        contacts.get(i).setPh_no(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter the email address to be edited");
                        contacts.get(i).setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        }

    }

    public void deleteContact() {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getF_name().equalsIgnoreCase(searchByName)) {
                contacts.remove(i);
                System.out.println("Deleted successfully" + contacts.size());
            }
        }
    }

    public void uc8_searchByCity(String citySearch) {
        searchByCity = contacts.stream().filter(x -> x.getCity().equalsIgnoreCase(citySearch)).collect(Collectors.toList());
        searchByCity.forEach(x -> System.out.println(x));
    }

    public void uc8_searchByState(String stateSearch) {
        searchByState = contacts.stream().filter(x -> x.getState().equalsIgnoreCase(stateSearch)).collect(Collectors.toList());
        searchByState.forEach(x -> System.out.println(x));
    }
}
