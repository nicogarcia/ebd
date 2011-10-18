package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logic.DBAccess;
import logic.User;

public class StartScreen extends JFrame implements ActionListener {

	public StartScreen() {
		// FIXME Usa el decorado del sistema, se pone lento con el Shell
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
		initGui();
	}

	private void initGui() {
		lbl_usuario = new JLabel("Usuario:");
		lbl_password = new JLabel("Contraseña:");

		usuario = new JTextField("admin");
		password = new JPasswordField("admin");

		login = new JButton("Ingresar");
		login.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(lbl_usuario);
		panel.add(usuario);
		panel.add(lbl_password);
		panel.add(password);

		add(panel, BorderLayout.CENTER);
		add(login, BorderLayout.SOUTH);

		setTitle("Sistema de Parquimetros - Principal");
		setPreferredSize(new Dimension(width, height));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - width) / 2,
				(screenSize.height - height) / 2);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();
	}

	public void actionPerformed(ActionEvent e) {
		User user = DBAccess.login(usuario.getText(),
				String.valueOf(password.getPassword()));
		if (!user.isLogged())
			JOptionPane.showMessageDialog(this,
					"Nombre de usuario y/o contraseña invalidos", "Error",
					JOptionPane.ERROR_MESSAGE, null);
		else {
			user.startScreen();
			dispose(); //FIXME Van al reves?
		}
	}

	JLabel lbl_usuario;
	JLabel lbl_password;
	JTextField usuario;
	JPasswordField password;
	JButton login;

	private final int width = 500;
	private final int height = 150;

}
