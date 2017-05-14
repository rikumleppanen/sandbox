package fi.sandbox.logic;

import fi.sandbox.logic.interfaces.matchingInterface;
import fi.sandbox.logic.Information;

public class Number extends Information implements matchingInterface {

    public Number(String row) {
        super(row);
        super.setType(Type.phone);
    }

    @Override
    public String getRow() {
        return super.getRow();
    }

}
