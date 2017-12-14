package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * 
 * @version 15/10/2017
 */
public class Reader {

	/**
	 * 
	 */
	private File file;

	/**
	 * 
	 */
	private FileReader fr;

	/**
	 * 
	 */
	private BufferedReader br;

	/**
	 * 
	 */
	public Reader(String fileLocation) {
		file = new File(fileLocation);
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
		br = new BufferedReader(fr);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<String>> readFile() {

		ArrayList<ArrayList<String>> arrayOfLines = new ArrayList<>();

		String line = null;
		String[] lineList = null;
		String[] stationList = null;

		try {
			while ((line = br.readLine()) != null) {
				lineList = line.split("\\n");

				for (int i = 0; i < lineList.length; i++) {
					ArrayList<String> arrayOfStations = new ArrayList<>();

					arrayOfLines.add(arrayOfStations);
					stationList = lineList[i].split(",");

					for (int x = 0; x < stationList.length; x++) {
						arrayOfStations.add(stationList[x]);
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return arrayOfLines;
	}
}
