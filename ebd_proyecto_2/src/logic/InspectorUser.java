package logic;

public class InspectorUser extends User {
	
	Integer id_asociado_con = null;

	public InspectorUser(String usuario, String clave, String uri) {
		
		super("inspector", "inspector", uri);
		
		inspector = true;
		
		Result res = execQuery("SELECT PASSWORD FROM inspectores WHERE legajo = '"
				+ usuario + "'");
		String pass = null;

		if (res.getCurrentRow() != null)
			pass = res.getCurrentRow()[0];

		if (!clave.equals(pass))
			logged = false;

		this.usuario = usuario;

		res.closeQuery();
	}
	
	public boolean isAssociated() {
		return id_asociado_con != null;
	}
	
	public Integer getIDAsociadoCon() {
		return id_asociado_con;
	}
	
	public void setIDAsociadoCon(Integer id) {
		id_asociado_con = id;
	}
}
