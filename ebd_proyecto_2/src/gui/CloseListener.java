package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CloseListener implements WindowListener {

	public void windowActivated(WindowEvent e) {
	}

	
	public void windowClosed(WindowEvent e) {
		new LoginScreen();
	}
	
	
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {

	}
	public void windowOpened(WindowEvent e) {
	}

}
