package model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Joshua Gallagher Thomas Geraghty Dimitar Stoynev
 * @version 15/10/2017
 */
public class Station extends AbstractNode {

    private final Set<Line> stationInLines = new HashSet<>();
    private String stationName;
    
    /**
     * 
     * @param stationName
     */
    public Station(String stationName) {
        this.stationName = stationName;
    }

    /**
     * Returns name of station.
     * 
     * @return String stationName
     */
    public String getStationName() {
        return this.stationName;
    }

    /**
     * Adds station to a line.
     * @param line
     */
    public boolean addLine(Line line) {
        if (stationInLines.add(line)) {
        		return true;
        }
        return false;
    }

    /**
     * Returns an ArrayList containing what Lines station is part of.
     * 
     * @return HashSet
     */
    public Set<Line> getStationInLines() {
        return stationInLines;
    }

    /**
     * 
     * @return String stationName
     */
    public String toString() {
        return this.stationName;
    }
}
