package model;

import java.util.HashSet;

public class Station extends AbstractNode {

    private final HashSet<Line> STATION_IN_LINES = new HashSet<Line>();
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
        return stationName;
    }

    /**
     * Adds station to a line.
     * @param line
     */
    public void addLine(Line line) {
        STATION_IN_LINES.add(line);
    }

    /**
     * Returns an ArrayList containing what Lines station is part of.
     * 
     * @return HashSet
     */
    public HashSet<Line> getSTATION_IN_LINES() {
        return STATION_IN_LINES;
    }

    /**
     * 
     * @return String stationName
     */
    public String toString() {
        return stationName;
    }
}
