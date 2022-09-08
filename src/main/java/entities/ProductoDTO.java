package entities;

public class ProductoDTO {

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private String codigo, nombre, descripcion, nom_categoria;
	private double precio;
	private int stock, categoria;

	public String getNom_categoria() {
		return nom_categoria;
	}

	public void setNom_categoria(String nom_categoria) {
		this.nom_categoria = nom_categoria;
	}

	@Override
	public String toString() {
		return "ProductoDTO [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", nom_categoria=" + nom_categoria + ", precio=" + precio + ", stock=" + stock + ", categoria="
				+ categoria + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
