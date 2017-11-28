package core;

import controller.TUIController;
import model.MTR;
import reader.Interpreter;
import reader.Reader;
import view.TUIView;

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
