package app;

import gui.LoginScreen;
import logic.DBAccess;

public class Main {

	public static void main(String[] args) {
		DBAccess.initDB("localhost");

		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}*/
	
		new LoginScreen();
	}

}
