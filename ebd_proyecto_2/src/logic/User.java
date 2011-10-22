package logic;

import gui.AdminScreen;
import gui.InspectorScreen;
import gui.SellerScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public Result execute(String sql) {
		ResultSet rs = null;
		Result res = null;

		boolean failed = false;
		boolean modifies = false;

		Statement stmt;

		String errorDetail = "";

		try {
			stmt = con.createStatement();
			modifies = !stmt.execute(sql);
			rs = stmt.getResultSet();
		} catch (SQLException e) {
			failed = true;
			errorDetail = e.getMessage();
		}
		
		res = new Result(rs, modifies, failed);
		res.setErrorDetail(errorDetail);
		
		return res;
	}

	public boolean isLogged() {
		return logged;
	}

	public String getUsuario() {
		return usuario;
	}

}
