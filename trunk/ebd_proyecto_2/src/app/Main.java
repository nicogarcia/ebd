package app;

import gui.StartScreen;
import logic.DBAccess;

public class Main {

	public static void main(String[] args) {
		DBAccess.initDB("localhost");

		new StartScreen();
	}

}
