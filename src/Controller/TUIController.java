package controller;

import java.util.HashSet;

import model.Line;
import model.MTR;
import model.Station;

public class TUIController implements IController {

    private static final MTR mtr = MTR.getInstance();

    @Override
    public String listAllTermini() {
        String buffer = "";
        for(Line line : mtr.getLines().values()) {
            buffer += ("Line: " + line.getLineName());
            buffer += ("\n");
            buffer += ("Termini: " + line.getStationsInLine().get(0).getStationName() + " <-> " + line.getStationsInLine().get(line.getStationsInLine().size() - 1).getStationName());
            buffer += ("\n\n");
        }
        return buffer;
    }

    @Override
    public String listStationsInLine(String line) {
        try {
            Line line1 = mtr.getLine(line);
            String buffer = "";
            for (int i = 0; i < line1.getStationsInLine().size(); i++) {
                buffer += (line1.getStationsInLine().get(i).getStationName());
                if (i < (line1.getStationsInLine().size() - 1)) {
                    buffer += " <-> ";
                }
            }
            return buffer;
        } catch (NullPointerException ex) {
            return ("No line with name '" + line + "' in system.");
        }
    }

    @Override
    public String listAllDirectlyConnectedLines(String line) {
        try {
            Line line1 = mtr.getLine(line);
            HashSet<Line> linkedLines = new HashSet<Line>();
            String buffer = "";

            for (Station station : line1.getStationsInLine()) {
                linkedLines.addAll(station.getStationInLines());
            }
            linkedLines.remove(line1);

            for (Line lines : linkedLines) {
                buffer += lines.getLineName();
                buffer += "\n";
            }
            return buffer;
        } catch (NullPointerException ex) {
            return ("No line with name '" + line + "' in system.");
        }
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        try {
            Station stationAObject = mtr.getStation(stationA);
            if(stationAObject == null) {
                throw new NullPointerException(stationA);
            }
            Station stationBObject = mtr.getStation(stationB);
            if(stationBObject == null) {
                throw new NullPointerException(stationB);
            }
            return stationAObject.bfsFromHere(stationBObject);
        } catch (NullPointerException ex) {
            return ("No station with name '" + ex.getMessage() + "' in system.");
        }
    }
}