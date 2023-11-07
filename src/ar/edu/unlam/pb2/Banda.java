package ar.edu.unlam.pb2;

import java.util.Objects;

public class Banda {

	private Integer idBanda;
	private String nombre;

	public Banda(Integer idBanda, String nombre) {
		this.idBanda = idBanda;
		this.nombre = nombre;
	}

	public Integer getIdBanda() {
		return idBanda;
	}

	public void setIdBanda(Integer idBanda) {
		this.idBanda = idBanda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBanda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banda other = (Banda) obj;
		return Objects.equals(idBanda, other.idBanda);
	}

}
