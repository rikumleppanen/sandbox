package fi.sandbox;

import fi.sandbox.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactList implements sortingInterface {

    private List<Contact> contacts;

    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public void addAContactToList(Contact one) {
        if (one != null) {
            this.contacts.add(one);
        }
    }

    public int binarySearch(String row) {

        Contact one = new Contact(row);
        int index = Collections.binarySearch(contacts, one, new SorterClass());
        return index;
    }

    public int size() {
        return contacts.size();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact get(int key) {
        return contacts.get(key);
    }

    public void cleanAndLabelNumber(Contact one) {
        if (one.inNumberFormat() == true) {
            one.setType(Type.phone);
        } else {
            one.numberClean();
            labelNumber(one);
        }
    }

    public void labelNumber(Contact one) {
        if (one.inNumberFormat() == true) {
            one.setType(Type.phone);
        } else {
            one.setType(Type.foreign);
        }
    }

    public void cleanAndClassify() {
        for (Contact item : contacts) {
            if (item.isEmail() == true) {
                labelEmail(item);
            } else {
                cleanAndLabelNumber(item);
            }
        }
    }

    public void labelEmail(Contact one) {
        if (one.isValidEmailAddress() == true) {
            one.setType(Type.email);
        } else {
            one.setType(Type.unknown);
        }
    }

    public void print() {
        for (Contact one : contacts) {
            System.out.println(one.getRow() + " Type: " + one.getType() + " State: " + one.getLabel());
        }
    }

    @Override
    public void sorting() {
        Collections.sort(contacts, new SorterClass());
    }

}
