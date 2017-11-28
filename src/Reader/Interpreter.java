package reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Line;
import model.MTR;
import model.Station;

public class Interpreter {

	/**
	 * 
	 * @param input
	 */
	public Interpreter(Reader input, MTR mtr) {
		interpretCSV(input, mtr);
	}

	/**
	 * 
	 * @param input
	 */
	private void interpretCSV(Reader input, MTR mtr) {
		ArrayList<ArrayList<String>> lines = input.readFile();
		Map<String, Station> importedStations = new HashMap<>();

		for (ArrayList<String> lineArray : lines) {
			Line line = new Line(lineArray.get(0));

			for (int i = 1; i < lineArray.size(); i++) {
				Station station;
				String stationName = lineArray.get(i);

				if (importedStations.get(stationName) == null) {
					station = new Station(stationName);
					importedStations.put(stationName, station);
				} else {
					station = importedStations.get(stationName);
				}
				line.addStation(station);
				station.addLine(line);
				mtr.addStation(station);
			}

			for (int i = 0; i < line.getStationsInLine().size(); i++) {
				if (i > 0) {
					line.getStationsInLine().get(i).addConnectedNode(line.getStationsInLine().get(i - 1));
				}
				if (i < (line.getStationsInLine().size() - 1)) {
					line.getStationsInLine().get(i).addConnectedNode(line.getStationsInLine().get(i + 1));
				}
			}
			mtr.addLine(line);
		}
	}
}
