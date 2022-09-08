package entities;

public class ClienteDTO {

	private String codigo;

	@Override
	public String toString() {
		return "ClienteDTO [codigo=" + codigo + ", nroDoc=" + nroDoc + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", coddist=" + coddist + ", correo=" + correo + ", clave=" + clave + ", nom_dist=" + nom_dist + "]";
	}

	private String nroDoc;
	private String nombre;
	private String apellido;
	private String direccion;
	private int coddist;
	private String correo, clave, nom_dist;

	public String getNom_dist() {
		return nom_dist;
	}

	public void setNom_dist(String nom_dist) {
		this.nom_dist = nom_dist;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCoddist() {
		return coddist;
	}

	public void setCoddist(int coddist) {
		this.coddist = coddist;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
