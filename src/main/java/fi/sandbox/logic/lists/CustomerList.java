package fi.sandbox.logic.lists;

import fi.sandbox.logic.Contact;
import fi.sandbox.logic.Customer;
import fi.sandbox.logic.Customer;
import fi.sandbox.logic.Information;
import fi.sandbox.logic.interfaces.MatcherClass;
import fi.sandbox.logic.State;
import fi.sandbox.logic.Type;
import fi.sandbox.logic.interfaces.SorterClass;
import fi.sandbox.logic.interfaces.matchingInterface;
import fi.sandbox.logic.interfaces.sortingInterface;
import fi.sandbox.logic.lists.ContactList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CustomerList implements sortingInterface {

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

    public void updateACustomer(Contact one, Type type, String row) {
        int index = Collections.binarySearch(customers, one, new SorterClass());
        if (index >= 0) {
            if (type == Type.email) {
                customers.get(index).addEmail(row);
            }
            if (type == Type.phone || type == Type.foreign) {
                customers.get(index).addNumber(row);
            }
        }
    }

    public Customer getCustomer(Contact one) {
        int index = Collections.binarySearch(customers, one, new SorterClass());
        if (index >= 0) {
            return customers.get(index);
        }
        return null;
    }

    public Customer getCustomer(Customer one) {
        int index = Collections.binarySearch(customers, one, new SorterClass());
        if (index >= 0) {
            return customers.get(index);
        }
        return null;
    }

    public void createAndUpdate(ContactList contacts) {
        Map<Integer, List<Contact>> list = contacts.getMap();
        for (Integer key : list.keySet()) {
            for (int i = 0; i < list.get(key).size(); i++) {
                Customer one = getCustomer(list.get(key).get(i));
                if (one != null) {
                    updateACustomer(list.get(key).get(i), list.get(key).get(i).getType(), list.get(key).get(i).getRow());
                } else {
                    addACustomerToList(new Customer().addInfo(list.get(key).get(i).getRow()));
                }
            }
        }

    }
//
//    */
//    public void createAndUpdate(Integer key, ContactList list) {
//        StateKeeper eye = findState(key, list);
//        for (int i = 0; i < eye.size(); i++) {
//            //System.out.println(eye.getState(i) + " " + eye.getContactRow(i).getRow() + " " + eye.getCustomer());
//            if (eye.getCustomer() == null) {
//                //Cases 1, 2, 3, 4, 5
//                addACustomerOrANewRow(key, i, eye, list);
//            } else if (eye.getState(i) == State.notFound) {
//                //Cases 11, 12
//                UUID cusno = eye.getCustomer();
//                updateExistingCustomer(getCustomerCusnoId(cusno), eye.getContactRow(i).getRowAsString(), eye.getContactRow(i).getType());
//            } else if (eye.isIdenticalRow() == true) {
//                //Cases 6, 7, 8, 9, 10
//                UUID cusno = eye.getCustomer();
//                updateExistingCustomer(getCustomerCusnoId(cusno), eye.getContactRow(i).getRowAsString(), eye.getContactRow(i).getType());
//            }
//        }
//    }

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

    public void sorting() {
        Collections.sort(customers, new SorterClass());
    }
}
