package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenPorApodo implements Comparator<Persona> {

	@Override
	public int compare(Persona primerPersona, Persona segundaPersona) {
		return primerPersona.getApodo().compareTo(segundaPersona.getApodo());
	}

}
