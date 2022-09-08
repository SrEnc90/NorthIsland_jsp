package entities;

public class CategoriaDTO {

	private String nombre;
	private int codigo;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
