package core;

import controller.TUIController;
import model.MTR;
import reader.Interpreter;
import reader.Reader;
import view.TUIView;

/**
 * 
 * @author Joshua Gallagher Thomas Geraghty Dimitar Stoynev
 * @version 15/10/2017
 */
public class MTRSystem {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MTR mtr = new MTR();
        new Interpreter(new Reader("resources/MTRsystem_partial.csv"), mtr);
        new TUIView(new TUIController(mtr));
	}

}
