package fi.sandbox.logic;

import fi.sandbox.logic.interfaces.SorterClass;
import fi.sandbox.logic.interfaces.matchingInterface;
import fi.sandbox.logic.interfaces.sortingInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Customer implements matchingInterface {

    private UUID cusno;
    private int insertID;
    private List<Information> list;

    public Customer() {
        this.cusno = UUID.randomUUID();
        this.insertID = 0;
        this.list = new ArrayList<>();
    }

    public UUID getCustomerID() {
        return this.cusno;
    }
    
    public int getCustomerInsertID() {
        return this.insertID;
    }

    public Customer addInsertID(int num) {
        this.insertID = num;
        return this;
    }
    public Customer addInfo(String row) {
        Information one = new Information(row);
        this.list.add(one);
        return this;
    }

    public Customer addEmail(String row) {
        Email one = new Email(row);
        this.list.add(one);
        return this;
    }

    public Customer addNumber(String row) {
        Number one = new Number(row);
        this.list.add(one);
        return this;
    }

    public Information isType(Type type) {
        for (Information info : list) {
            if (info.getType() == type) {
                return info;
            }
        }
        return null;
    }

    public String getInfo() {
        String line = "";
        for (Information info : list) {
            line += " " + info.getRow();
        }
        return line;
    }

    @Override
    public String getRow() {
        return this.cusno.toString();
    }

}
