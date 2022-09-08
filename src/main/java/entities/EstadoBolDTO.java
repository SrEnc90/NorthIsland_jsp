package entities;

public class EstadoBolDTO {

	private int codigo;
	private String descripcion;

	@Override
	public String toString() {
		return "EstadoBolDTO [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
