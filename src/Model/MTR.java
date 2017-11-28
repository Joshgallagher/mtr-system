package model;

import java.util.HashMap;
import java.util.Map;

public class MTR {

    private final Map<String, Line> listOfLines;
    private final Map<String, Station> listOfStations;

    public MTR() {
    		this.listOfLines = new HashMap<>();
    		this.listOfStations = new HashMap<>();
    }

    /**
     * Adds passed Line object to list of current lines in the system.
     * 
     * @param line      Line object to add.
     */
    public void addLine(Line line) {
        listOfLines.put(line.getLineName(), line);
    }

    /**
     * Returns the corresponding Line object from a line's name which is passed.
     * 
     * @param lineName
     * @return
     */
    public Line getLine(String lineName) {
        try {
            if(listOfLines.containsKey(lineName)) {
                return listOfLines.get(lineName);
            } else {
                throw new NullPointerException("No such Line with that name.");
            }
        } catch (NullPointerException e){
            return null;
        }
    }

    /**
     * Returns all the Line objects in the MTR, in an ArrayList.
     * 
     * @return  ArrayList<Line>     ArrayList containing Line objects.
     */
    public Map<String, Line> getLines() {
        return listOfLines;
    }

    /**
     * Adds station to HashMap of stations, checks if duplicate station, and if so
     * does not create a new station entry, but instead merges original with duplicate..
     * Adds the station to the line it is on, too,
     * 
     * @param station       Station to add to system.
     */
    public void addStation(Station station) {
        listOfStations.put(station.getStationName(), station);
    }

    /**
     * Returns corresponding Station object based on passed station name.
     * 
     * @param stationName
     * @return
     */
    public Station getStation(String stationName) {
        try {
            if(listOfStations.containsKey(stationName)) {
                return listOfStations.get(stationName);
            } else {
                throw new NullPointerException("No such Station with that name.");
            }
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Returns all the Station objects in the MTR, in an ArrayList.
     * 
     * @return  ArrayList<Station>     ArrayList containing Station objects.
     */
    public Map<String, Station> getStations() {
        return listOfStations;
    }
}
