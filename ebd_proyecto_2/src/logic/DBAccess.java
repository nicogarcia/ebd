package logic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAccess {

	private static String uriConexion = "jdbc:mysql://";

	public static void initDB(String servidor) {
		try {
			uriConexion += servidor + "/";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException ex) {
			Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}
	
	public static User login(String usuario, String password) {
		return new User(usuario, password, uriConexion + "parquimetros");
	}
}
