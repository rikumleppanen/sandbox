package fi.sandbox.logic.interfaces;


import fi.sandbox.logic.interfaces.matchingInterface;
import java.util.Comparator;

public class MatcherClass implements Comparator<matchingInterface> {

    @Override
    public int compare(matchingInterface m1, matchingInterface m2) {
        return m1.getRow().compareTo(m2.getRow());
    }

}
