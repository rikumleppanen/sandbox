package fi.sandbox;

import fi.sandbox.logic.FileReader;
import fi.sandbox.logic.lists.CustomerList;
import fi.sandbox.logic.Customer;
import fi.sandbox.logic.lists.ContactList;
import fi.sandbox.logic.Contact;

public class sandbox {

    public static void main(String[] args) {

        ContactList contacts = new ContactList();
        FileReader just = new FileReader(contacts);
        just.read("koe1_1.txt");

        contacts.addAContactToList(new Contact("malli@gemmi.com"));
        contacts.addAContactToList(new Contact("aabeli@gammi.fi"));
        contacts.addAContactToList(new Contact("velli@gelli.ch"));
        contacts.addAContactToList(new Contact("vattu@vatuttaa.tv"));
        long startTime = System.currentTimeMillis();
        contacts.cleanAndClassify();
        contacts.sorting();
        System.out.println(contacts.binarySearch("velli@gelli.ch"));
        CustomerList customers = new CustomerList();
        loadingExistingCustomers(customers);
        Customer abe = new Customer();
        abe.addEmail("aabeli@gammi.fi");
        Customer bea = new Customer();
        bea.addEmail("vallunki@kuopio.fi");
        Customer cea = new Customer();
        cea.addEmail("vattu@vatuttaa.tv");
        cea.addNumber("0300631366");
        customers.addACustomerToList(abe);
        customers.addACustomerToList(bea);
        customers.addACustomerToList(cea);
        customers.compareAndLabelContacts(contacts);
        contacts.addAContactRowToList();
        customers.createAndUpdate(contacts);
        long endTime = System.currentTimeMillis();
        System.out.println(printTime(startTime, endTime));
        customers.print();
        System.out.println("sssss");
        contacts.print();

//        Map<String, String> mappi = new HashMap<>();
        //
        //        String[] contactrows = "a|b|c|d".split("|");
        //        for (String row : contactrows) {
        //            if (mappi.containsKey(row)) {
        //                return mappi.get(row);
        //            }
        //        }
    }

    public static String printTime(long startTime, long endTime) {
        String text = "";
        if (endTime - startTime <= 1000) {
            text = "The parsing and matching process took " + (endTime - startTime) + " milliseconds.";
        } else {
            text = "The parsing and matching process took " + (endTime - startTime) / 1000 + " seconds.";
        }
        return text;
    }

        
    public static void loadingExistingCustomers(CustomerList customers) {
        Customer a = new Customer();
        a.addEmail("a4@a4.fi");
        Customer b = new Customer();
        b.addNumber("0507378716");
        Customer c = new Customer();
        c.addEmail("uc6@uc6.fi");
        Customer d = new Customer();
        d.addNumber("070345678");
        Customer e = new Customer();
        e.addEmail("uc8@uc8.fi");
        e.addNumber("0812345673");
        Customer f = new Customer();
        f.addEmail("auc9@auc9.com");
        f.addNumber("0912334342");
        Customer g = new Customer();
        g.addEmail("auc10@auc10.fi");
        g.addNumber("102343434");
        Customer h = new Customer();
        h.addEmail("cuc11@cuc11.com");
        h.addNumber("1111122222");
        Customer i = new Customer();
        i.addNumber("0403456789");
        i.addEmail("cuc12cuc@cuc12cuc12.fi");
        customers.addACustomerToList(a);
        customers.addACustomerToList(b);
        customers.addACustomerToList(c);
        customers.addACustomerToList(d);
        customers.addACustomerToList(e);
        customers.addACustomerToList(f);
        customers.addACustomerToList(g);
        customers.addACustomerToList(h);
        customers.addACustomerToList(i);
        
    }

}
