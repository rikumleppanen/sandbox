package fi.sandbox;


public class Customer implements matchingInterface {

    private String email;

    public Customer(String email) {
        this.email = email;
    }

    @Override
    public String getRow() {
        return this.email;
    }

}
