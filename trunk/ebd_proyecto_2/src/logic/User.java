package logic;

import gui.AdminScreen;
import gui.InspectorScreen;
import gui.SellerScreen;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

	String usuario;
	Connection con;
	boolean logged;
	boolean inspector = false;

	public User(String usuario, String clave, String uri) {
		this.usuario = usuario;
		logged = true;
		try {
			con = DriverManager.getConnection(uri, usuario, clave);
		} catch (SQLException ex) {
			// FIXME Asegurar que sea error de user-pass
			logged = false;
		}
	}

	public void startScreen() {
		if (isLogged()) {
			if (usuario.equals("admin")) {
				new AdminScreen(this);
			} else if (usuario.equals("venta")) {
				new SellerScreen(this);
			} else if (inspector) {
				new InspectorScreen(this);
			}
		}
	}

	public Result execQuery(String query) {
		ResultSet rs = null;
		try {
			rs = con.createStatement().executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new Result(rs);
	}

	public boolean execInsert(String sql) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean isLogged() {
		return logged;
	}

	public String getUsuario() {
		return usuario;
	}

}
