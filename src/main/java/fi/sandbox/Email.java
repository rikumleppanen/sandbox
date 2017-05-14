package fi.sandbox;

public class Email extends Information implements matchingInterface {

    public Email(String row) {
        super(row);
        super.setType(Type.email);

    }

    @Override
    public String getRow() {
        return super.getRow();
    }

}
