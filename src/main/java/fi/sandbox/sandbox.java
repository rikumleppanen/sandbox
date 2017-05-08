package fi.sandbox;

public class sandbox {

    public static void main(String[] args) {

        ContactList contacts = new ContactList();
        FileReader just = new FileReader(contacts);
        just.read("newfile.txt");

        contacts.addAContactToList(new Contact("malli@gemmi.com"));
        contacts.addAContactToList(new Contact("aabeli@gammi.fi"));
        contacts.addAContactToList(new Contact("velli@gelli.ch"));
        contacts.addAContactToList(new Contact("vattu@vatuttaa.tv"));
        long startTime = System.currentTimeMillis();
        contacts.sorting();
        System.out.println(contacts.binarySearch("velli@gelli.ch"));
        CustomerList customers = new CustomerList();
        customers.addACustomerToList(new Customer("aabeli@gammi.fi"));
        customers.addACustomerToList(new Customer("vallunki@kuopio.fi"));
        customers.addACustomerToList(new Customer("vattu@vatuttaa.tv"));
        customers.binarySearch(contacts);
        long endTime = System.currentTimeMillis();
        System.out.println(printTime(startTime, endTime));
        //customers.print();

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

}
