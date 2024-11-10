public class Usuario {

	private String nombre;
	private String contrasena;
	private String cargo;
	
	
	protected Usuario(String nombre, String contrasena, String cargo) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.cargo = cargo;
	}


	protected String getNombre() {
		return nombre;
	}


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}


	protected String getContrasena() {
		return contrasena;
	}


	protected void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	protected String getCargo() {
		return cargo;
	}


	protected void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}

