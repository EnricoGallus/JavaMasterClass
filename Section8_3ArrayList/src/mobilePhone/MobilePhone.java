package mobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        int index = findContact(contact.getName());
        if (index < 0) {
            myContacts.add(contact);
            return true;
        }

        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact.getName());
        if (index >= 0) {
            myContacts.add(index, newContact);
            return true;
        }

        return false;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact.getName());
        if (index >= 0) {
            myContacts.remove(index);
            return true;
        }

        return false;
    }

    public Contact queryContact(String name) {
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(name)) {
                return myContact;
            }
        }

        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
