package controller;

import java.util.HashSet;
import java.util.List;

import model.AbstractNode;
import model.Line;
import model.MTR;
import model.Station;

public class TUIController implements IController {

    private static final MTR mtr = MTR.getInstance();

    /**
     * 
     */
    public String listAllTermini() {
    		StringBuffer buffer = new StringBuffer();
        for(Line line : mtr.getLines().values()) {
            buffer.append("Line: " + line.getLineName());
            buffer.append("\n");
            buffer.append("Termini: " + line.getStationsInLine().get(0).getStationName() + " <-> " + line.getStationsInLine().get(line.getStationsInLine().size() - 1).getStationName());
            buffer.append("\n\n");
        }
        return buffer.toString();
    }

    /**
     * 
     */
    public String listStationsInLine(String line) {
    		StringBuffer buffer = new StringBuffer();
        try {
            Line line1 = mtr.getLine(line);
            for (int i = 0; i < line1.getStationsInLine().size(); i++) {
                buffer.append(line1.getStationsInLine().get(i).getStationName());
                if (i < (line1.getStationsInLine().size() - 1)) {
                    buffer.append(" <-> ");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 
     */
    public String listAllDirectlyConnectedLines(String line) {
    		StringBuffer buffer = new StringBuffer();
    		
        try {
            Line line1 = mtr.getLine(line);
            HashSet<Line> linkedLines = new HashSet<Line>();

            for (Station station : line1.getStationsInLine()) {
                linkedLines.addAll(station.getStationInLines());
            }
            linkedLines.remove(line1);

            for (Line lines : linkedLines) {
                buffer.append(lines.getLineName());
                buffer.append("\n");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 
     */
    public String showPathBetween(String stationA, String stationB) {

    		Station stationAObject = mtr.getStation(stationA);
    		Station stationBObject = mtr.getStation(stationB);
    		
    		List<AbstractNode> stationList = stationAObject.bfsFromHere(stationBObject);
    		StringBuffer buffer = new StringBuffer();
    		
    		for (AbstractNode station : stationList) {
    			buffer.append(station);
    			if (!station.equals(stationList.get(stationList.size() - 1))) buffer.append(" -> ");
    		}
    		
    		return buffer.toString();
    }
}