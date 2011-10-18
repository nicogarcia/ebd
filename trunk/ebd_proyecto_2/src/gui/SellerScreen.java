package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import logic.User;

public class SellerScreen extends JFrame {
	
	public SellerScreen(User user) {
		initGui();
	}

	private void initGui() {

		setTitle("Sistema de Parquimetros - Usuario: Vendedor");
		setPreferredSize(new Dimension(width, height));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();
	}
	
	private final int width = 500;
	private final int height = 300;
}
