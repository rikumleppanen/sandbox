package fi.sandbox;

import fi.sandbox.Customer;
import fi.sandbox.ContactList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerList {

    private List<Customer> customers;
    private List<Information> emails;
    private List<Information> numbers;

    public CustomerList() {
        this.customers = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.numbers = new ArrayList<>();
    }

    public void addACustomerToList(Customer one) {
        if (one != null) {
            this.customers.add(one);
            if (one.isType(Type.email) != null) {
                this.emails.add(one.isType(Type.email));
            } else if (one.isType(Type.phone) != null) {
                this.numbers.add(one.isType(Type.phone));
            } else if (one.isType(Type.foreign) != null) {
                this.numbers.add(one.isType(Type.foreign));
            }
        }
    }

    public void compareAndLabelContacts(ContactList contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getType() == Type.email) {
                int index = Collections.binarySearch(emails, contacts.get(i), new MatcherClass());
                if (index < 0) {
                    contacts.get(i).setState(State.notFound);
                } else {
                    contacts.get(i).setState(State.sameEmail);
                }
            } else if (contacts.get(i).getType() == Type.phone || contacts.get(i).getType() == Type.foreign) {
                int index = Collections.binarySearch(numbers, contacts.get(i), new MatcherClass());
                if (index < 0) {
                    contacts.get(i).setState(State.notFound);
                } else {
                    contacts.get(i).setState(State.sameNumber);
                }
            }

//            if(index < 0) {
//                addACustomerToList(new Customer(contacts.get(i).getRow()));
//            }
        }
    }

    public void print() {
        for (Customer one : customers) {
            System.out.println(one + " " + one.getInfo());
        }
    }

}
