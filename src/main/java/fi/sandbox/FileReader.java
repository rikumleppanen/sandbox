package fi.sandbox;


import fi.sandbox.ContactList;
import fi.sandbox.Contact;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileReader produces a list where all the individual contact rows are added.
 * It keeps record of the total number of rows as well.
 */
public class FileReader {

    private ContactList list;
    private int countRows;

    /**
     * The FileReader as not yet read any rows, since the count is zero at the
     * beginning.
     */
    public FileReader(ContactList list) {
        this.list = list;
        this.countRows = 0;
    }

    /**
     * Method reads each row of a file and adds contacts.
     *
     * @param file is the file name that will be read
     */
    public void read(String file) {
        try (Scanner reader = new Scanner(new File(file), "UTF-8")) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                //String[] items = row.split("\\|");
                //int id = Integer.valueOf(items[1]);
                list.addAContactToList(new Contact(row));
                countRows++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No can do");
        }
    }

    /**
     * Method reads each row of a file and adds contacts from the InputStream.
     *
     * @param is is the InputStream
     */
    public void readInputStream(InputStream is) {
        try (Scanner reader = new Scanner(is, "UTF-8")) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                //String[] items = row.split("\\|");
                //int id = Integer.valueOf(items[1]);
                list.addAContactToList(new Contact(row));
                countRows++;
            }
        } catch (Exception e) {
        }
    }

    /**
     * The number of downloaded rows can be obtained.
     *
     * @return is the number of rows which were downloaded to the system
     */
    public int getNumberOfRows() {
        return this.countRows;
    }

}
