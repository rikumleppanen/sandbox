package fi.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private UUID cusno;
    private List<Information> list;

    public Customer() {
        this.cusno = UUID.randomUUID();
        this.list = new ArrayList<>();
    }

    public void addInfo(String row) {
        Information one = new Information(row);
        this.list.add(one);
    }

    public void addEmail(String row) {
        Email one = new Email(row);
        this.list.add(one);
    }

    public void addNumber(String row) {
        Number one = new Number(row);
        this.list.add(one);
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
}
