package entities;

public class AdministradorDTO {

	private String ID_admi;
	private String nom_admi;
	private String ape_admi;
	private String DNI_admi;
	private String fechNac_admi;
	private int cod_dist;
	private String email_admi;
	private String usuario_admi;
	private String clave_admi;
	private int ID_cargo;
	private String nom_cargo;
	private String nom_distrito;
	private double sueldo;

	public String getNom_cargo() {
		return nom_cargo;
	}

	public void setNom_cargo(String nom_cargo) {
		this.nom_cargo = nom_cargo;
	}

	public String getNom_distrito() {
		return nom_distrito;
	}

	public void setNom_distrito(String nom_distrito) {
		this.nom_distrito = nom_distrito;
	}

	@Override
	public String toString() {
		return "AdministradorDTO [ID_admi=" + ID_admi + ", nom_admi=" + nom_admi + ", ape_admi=" + "ape_admi"
				+ ", DNI_admi=" + DNI_admi + ", fechNac_admi=" + fechNac_admi
				+  ", cod_dist=" + cod_dist + ", email_admi=" + email_admi + ", usuario_admi=" + usuario_admi + ", clave_admi="
				+ clave_admi + ", ID_cargo=" + ID_cargo + ", nom_cargo=" + nom_cargo + ", nom_distrito=" + nom_distrito
				+", sueldo=" + sueldo + ", getID_admi()=" + getID_admi()
				+ ", getNom_admi()=" + getNom_admi() + ", getApe_admi()=" + getApe_admi() + ", getDNI_admi()=" + getDNI_admi() + ", getFechNac_admi()=" + getFechNac_admi()
				+ ", getCod_dist()=" + getCod_dist() + ",  getEmail_admi()=" + getEmail_admi()
				+ ", getUsuario_admi()=" + getUsuario_admi() + ", getClave_admi()=" + getClave_admi()
				+ ", getID_cargo()=" + getID_cargo() + ", getSueldo()="
				+ getSueldo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getID_admi() {
		return ID_admi;
	}

	public void setID_admi(String iD_admi) {
		ID_admi = iD_admi;
	}

	public String getNom_admi() {
		return nom_admi;
	}

	public void setNom_admi(String nom_admi) {
		this.nom_admi = nom_admi;
	}

	public String getApe_admi() {
		return ape_admi;
	}

	public void setApe_admi(String apePat_admi) {
		this.ape_admi = apePat_admi;
	}

	

	public String getDNI_admi() {
		return DNI_admi;
	}

	public void setDNI_admi(String dNI_admi) {
		DNI_admi = dNI_admi;
	}

	public String getFechNac_admi() {
		return fechNac_admi;
	}

	public void setFechNac_admi(String fechNac_admi) {
		this.fechNac_admi = fechNac_admi;
	}



	public int getCod_dist() {
		return cod_dist;
	}

	public void setCod_dist(int cod_dist) {
		this.cod_dist = cod_dist;
	}


	public String getEmail_admi() {
		return email_admi;
	}

	public void setEmail_admi(String email_admi) {
		this.email_admi = email_admi;
	}

	public String getUsuario_admi() {
		return usuario_admi;
	}

	public void setUsuario_admi(String usuario_admi) {
		this.usuario_admi = usuario_admi;
	}

	public String getClave_admi() {
		return clave_admi;
	}

	public void setClave_admi(String clave_admi) {
		this.clave_admi = clave_admi;
	}

	public int getID_cargo() {
		return ID_cargo;
	}

	public void setID_cargo(int iD_cargo) {
		ID_cargo = iD_cargo;
	}


	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

}
