package entities;

public class BoletaDTO {

	private String numerobol;
	private String fecha;
	private String cliente;
	private int estado;
	private double igv;
	private double subtotal;
	private double total;

	@Override
	public String toString() {
		return "BoletaDTO [numerobol=" + numerobol + ", fecha=" + fecha + ", cliente=" + cliente + ", estado=" + estado
				+ ", igv=" + igv + ", subtotal=" + subtotal + ", total=" + total + "]";
	}

	public String getNumerobol() {
		return numerobol;
	}

	public void setNumerobol(String numerobol) {
		this.numerobol = numerobol;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
