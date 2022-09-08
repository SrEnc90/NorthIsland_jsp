package entities;

public class RepBoletaDTO {

	private String numerobol;
	private String fecha;
	private String cliente;
	private int estado;
	private String desestado;
	private String igv;
	private String subtotal;
	private String total;

	@Override
	public String toString() {
		return "RepBoletaDTO [numerobol=" + numerobol + ", fecha=" + fecha + ", cliente=" + cliente + ", estado="
				+ estado + ", desestado=" + desestado + ", igv=" + igv + ", subtotal=" + subtotal + ", total=" + total
				+ "]";
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

	public String getDesestado() {
		return desestado;
	}

	public void setDesestado(String desestado) {
		this.desestado = desestado;
	}

	public String getIgv() {
		return igv;
	}

	public void setIgv(String igv) {
		this.igv = igv;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
