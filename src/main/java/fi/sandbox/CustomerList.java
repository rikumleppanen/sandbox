package fi.sandbox;


import fi.sandbox.Customer;
import fi.sandbox.ContactList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerList {

    private List<matchingInterface> customers;

    public CustomerList() {
        this.customers = new ArrayList<>();
    }

    public void addACustomerToList(Customer one) {
        if (one != null) {
            this.customers.add(one);
        }
    }

    public void binarySearch(ContactList contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            int index = Collections.binarySearch(customers, contacts.get(i), new MatcherClass());
            if(index < 0) {
                addACustomerToList(new Customer(contacts.get(i).getRow()));
            }

        }
    }
    public void print() {
        for(matchingInterface one : customers) {
            System.out.println(one.getRow());
        }
    }

}
