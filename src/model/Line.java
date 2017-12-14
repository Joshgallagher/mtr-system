package model;

import java.util.ArrayList;

/**
 * 
 * @author Joshua Gallagher Thomas Geraghty Dimitar Stoynev
 * @version 15/10/2017
 */
public class Line {

    private final ArrayList<Station> stationsInLine = new ArrayList<>();
    private String lineName;
    
    /**
     * 
     * @param lineName
     */
    public Line(String lineName) {
        this.lineName = lineName;
     }

    /**
     * Returns Line name.
     * 
     * @return String lineName
     */
    public String getLineName() {
        return this.lineName;
    }

    /**
     * Adds station to line.
     * 
     * @param station
     */
    public boolean addStation(Station station) {
        if (this.stationsInLine.add(station)) {
        		return true;
        }
        return false;
    }

    /**
     * Returns all STATIONS_IN_LINE of line.
     * 
     * @return
     */
    public ArrayList<Station> getStationsInLine() {
        return this.stationsInLine;
    }

    /**
     * 
     */
    public String toString() {
        return this.lineName;
    }
}
