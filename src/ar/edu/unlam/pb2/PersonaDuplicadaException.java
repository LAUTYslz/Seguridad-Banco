package ar.edu.unlam.pb2;

public class PersonaDuplicadaException extends Exception {

	public PersonaDuplicadaException() {
		super("Persona ya registrada");
	}
}
