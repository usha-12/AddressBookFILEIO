package com.brideglabz.addressbookfileio;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBookMain {
    static Contacts contact;
    static ArrayList<Contacts> contacts = new ArrayList<Contacts>(); //using Arraylist as it is easier than using Array
    public void CreatingContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the contact details");
        System.out.println("Enter the first name");
        String f_name = sc.next();
        System.out.println("Enter the last name");
        String l_name = sc.next();
        System.out.println("Enter the address");
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
    public static void main(String[] args) {
        System.out.println("Welcome to the address book program");
        AddressBookMain addressBook = new AddressBookMain();
        addressBook.CreatingContact();
        System.out.println(contact);
        addressBook.addingContacts();
        System.out.println(contacts.get(0));
    }
}
