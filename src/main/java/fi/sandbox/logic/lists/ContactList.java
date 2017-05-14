package fi.sandbox.logic.lists;

import fi.sandbox.logic.Contact;
import fi.sandbox.logic.Contact;
import fi.sandbox.logic.ContactRow;
import fi.sandbox.logic.State;
import fi.sandbox.logic.interfaces.SorterClass;
import fi.sandbox.logic.Type;
import fi.sandbox.logic.interfaces.sortingInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactList implements sortingInterface {

    private List<Contact> contacts;
    private Map<Integer, List<Contact>> map;

    public ContactList() {
        this.contacts = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void addAContactToList(Contact one) {
        if (one != null) {
            this.contacts.add(one);
        }
    }

    public void addAContactRowToList() {
        for (Contact item : contacts) {
            int nro = item.getInsertID();
            if (!map.containsKey(nro) && nro != 0) {
                map.put(nro, new ArrayList<>());
                map.get(nro).add(item);
            } else if (nro != 0) {
                map.get(nro).add(item);
            }
        }
    }

    public boolean noMatch(int key) {
        int k = 0;
        if (map.containsKey(key)) {
            int n = map.get(key).size();
            for (Contact item : map.get(key)) {
                if (item.getLabel() == State.notFound) {
                    k++;
                }
            }
            if (n == k) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, List<Contact>> getMap() {
        return this.map;
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
