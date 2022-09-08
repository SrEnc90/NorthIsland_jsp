package entities;

public class CargoDTO {

	private int idcargo;
	private String descripcion;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(int idcargo) {
		this.idcargo = idcargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
