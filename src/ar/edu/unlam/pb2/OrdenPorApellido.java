package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenPorApellido implements Comparator<Persona> {

	@Override
	public int compare(Persona primerPersona, Persona segundaPersona) {
		return primerPersona.getApellido().compareTo(segundaPersona.getApellido());
	}

}
