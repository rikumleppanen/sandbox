package fi.sandbox;


public class Contact implements matchingInterface {

    private String row;

    public Contact(String row) {
        this.row = row;
    }

    @Override
    public String getRow() {
        return this.row;
    }

}
