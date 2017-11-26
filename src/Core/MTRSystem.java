package core;

import controller.TUIController;
import reader.Interpreter;
import reader.Reader;
import view.TUIView;

public class MTRSystem {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        new Interpreter(
        		new Reader("resources/MTRsystem_partial.csv")
        	);
        new TUIView(
        		new TUIController()
        	);
	}

}
