package reader;

import java.util.ArrayList;
import java.util.HashMap;

import model.Line;
import model.MTR;
import model.Station;

public class Interpreter {
	
	/**
	 * 
	 * @param input
	 */
    public Interpreter(Reader input) {
        interpretCSV(input);
    }
    
    /**
     * 
     * @param input
     */
    private void interpretCSV(Reader input) {
        ArrayList<ArrayList<String>> lines = input.readFile();
        HashMap<String, Station> importedStations = new HashMap<>();

        for(ArrayList<String> lineArray : lines) {
            Line line = new Line(lineArray.get(0));

            for(int i = 1; i < lineArray.size(); i++) {
                String stationName = lineArray.get(i);
                Station station;

                if(importedStations.get(stationName) == null) {
                    station = new Station(stationName);
                    importedStations.put(stationName, station);
                } else {
                    station = importedStations.get(stationName);
                }
                line.addStation(station);
                station.addLine(line);
                MTR.getInstance().addStation(station);
            }

            for(int i = 0; i < line.getStationsInLine().size(); i++) {
                if(i > 0) {
                    line.getStationsInLine().get(i).addConnectedNode(line.getStationsInLine().get(i - 1));
                }
                if(i < (line.getStationsInLine().size() -1)) {
                    line.getStationsInLine().get(i).addConnectedNode(line.getStationsInLine().get(i + 1));
                }
            }
            MTR.getInstance().addLine(line);
        }
    }
}

