package fi.sandbox;


import fi.sandbox.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContactList implements sortingInterface {
    private List<matchingInterface> contacts;
    
    public ContactList() {
        this.contacts = new ArrayList<>();
    }
    
    public void addAContactToList(Contact one) {
        if(one != null) {
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
    
    public List<matchingInterface> getContacts() {
        return contacts;
    }
    
    public matchingInterface get(int key) {
        return contacts.get(key);
    }
    
    @Override
    public void sorting() {
        Collections.sort(contacts, new SorterClass());
    }
    
}
