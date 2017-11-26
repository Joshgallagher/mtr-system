package Core;

import Controller.TUIController;
import Reader.Interpreter;
import Reader.Reader;
import View.TUIView;

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
