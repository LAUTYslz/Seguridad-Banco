package ar.edu.unlam.pb2;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String apodo;

	public Persona(Integer dni, String nombre, String apellido, String apodo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
	}

	// para vigilante
	public Persona(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int compareTo(Persona otraPerson) {
		return this.getDni().compareTo(otraPerson.getDni());
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", apodo=" + apodo + "]";
	}

}
