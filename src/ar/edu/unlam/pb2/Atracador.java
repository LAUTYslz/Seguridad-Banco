package ar.edu.unlam.pb2;

public class Atracador extends Persona{

	private Banda banda;

	public Atracador(Integer dni, String nombre, String apellido, String apodo, Banda bandaDelAtracador) {
		super(dni, nombre, apellido, apodo);
		this.banda = bandaDelAtracador;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

}
