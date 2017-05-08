package fi.sandbox;


import java.util.Comparator;

public class SorterClass implements Comparator<matchingInterface> {
    
    @Override
    public int compare(matchingInterface c1, matchingInterface c2) {
        return c1.getRow().compareTo(c2.getRow());
    }


}
