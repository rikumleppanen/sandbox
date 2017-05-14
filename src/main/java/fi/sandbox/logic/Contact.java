package fi.sandbox.logic;

import fi.sandbox.logic.interfaces.matchingInterface;
import java.util.UUID;

public class Contact implements matchingInterface {

    private String row;
    private Type type;
    private State label;
    private int insertID;

    public Contact(String row) {
        this.row = row;
        this.type = Type.untyped;
        this.label = State.notStated;
        this.insertID = 0;
    }

    public Contact(String row, int insertID) {
        this.row = row;
        this.type = Type.untyped;
        this.label = State.notStated;
        this.insertID = insertID;
    }
    
    public int getInsertID() {
        return this.insertID;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setState(State label) {
        this.label = label;
    }

    public Type getType() {
        return type;
    }

    public State getLabel() {
        return label;
    }

    public boolean isEmail() {
        if (this.row.contains("@")) {
            return true;
        }
        return false;
    }

    public boolean isValidEmailAddress() {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(this.row);
        return m.matches();
    }

    public boolean inNumberFormat() {
        if (this.row.matches("0[0-9]{5,9}")) {
            return true;
        }
        return false;
    }

    public void numberClean() {
        this.row = this.row.replaceAll("[^a-zA-Z0-9+]", "");

        if (this.row.contains("+3580")) {
            this.row = this.row.replace("+3580", "0");
        }
        if (this.row.contains("+358")) {
            this.row = this.row.replace("+358", "0");
        }
        if (this.row.startsWith("3580") == true) {
            this.row = this.row.replace("358", "");
        }
        if (this.row.startsWith("358") == true) {
            this.row = this.row.replace("358", "0");
        }

    }

    @Override
    public String getRow() {
        return this.row;
    }

}
