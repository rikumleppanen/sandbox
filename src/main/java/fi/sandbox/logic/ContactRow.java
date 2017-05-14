package fi.sandbox.logic;

import java.util.ArrayList;
import java.util.List;

public class ContactRow {

    private Contact[] contacts;

    public void setN(int n) {
        this.contacts = new Contact[n];
    }

    public Contact getContactRow(int i) {
        return this.contacts[i];
    }
    public void addARow(Contact one, int i) {
        this.contacts[i] = one;
    
    }
}
