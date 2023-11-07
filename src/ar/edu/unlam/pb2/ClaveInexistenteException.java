package ar.edu.unlam.pb2;

public class ClaveInexistenteException extends Exception {

	public ClaveInexistenteException() {
		super("Clave buscada INEXISTENTE");
	}
}
