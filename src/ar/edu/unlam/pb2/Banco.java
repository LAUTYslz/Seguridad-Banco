package ar.edu.unlam.pb2;

import java.util.Objects;

public class Banco {

	private String nombre;
	private Integer idBanco;

	public Banco(Integer idBanco, String nombre) {

		this.idBanco = idBanco;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBanco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(idBanco, other.idBanco);
	}

}
