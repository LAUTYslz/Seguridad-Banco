package ar.edu.unlam.pb2;

public class Vigilante extends Persona {

	private Banco bancoPerteneciente;

	public Vigilante(Integer dni, String nombre, String apellido, Banco banco) {
		super(dni, nombre, apellido);
		this.bancoPerteneciente = banco;
	}

	public Banco getBancoPerteneciente() {
		return bancoPerteneciente;
	}

	public void setBancoPerteneciente(Banco bancoPerteneciente) {
		this.bancoPerteneciente = bancoPerteneciente;
	}

}
