package entities;

public class DistritoDTO {

	private int codigoDist;
	private String nombreDist;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getCodigoDist() {
		return codigoDist;
	}

	public void setCodigoDist(int codigoDist) {
		this.codigoDist = codigoDist;
	}

	public String getNombreDist() {
		return nombreDist;
	}

	public void setNombreDist(String nombreDist) {
		this.nombreDist = nombreDist;
	}

}
