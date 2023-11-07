package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Vigilancia {

	private String nombre;
	private Set<Persona> personas;
	private Set<Banco> bancos;

	// No se puede cambiar
	private Map<Integer, Atraco> atracos;

	/*
	 * Registra tanto como Vigiladores como atracadores no permite registrar 2
	 * personas con el mismo DNI. Si esto sucede lanza una exception
	 * PersonaDuplicadaException
	 * 
	 */

	public Vigilancia(String nombre) {
		this.nombre = nombre;
		this.bancos = new HashSet<>();
		this.personas = new HashSet<>();
		this.atracos = new HashMap<Integer, Atraco>();
	}

	public void registrarPersona(Persona personaNueva) throws PersonaDuplicadaException {
		if (!(existePersonaRegistrada(personaNueva))) {
			this.personas.add(personaNueva);
		}
	}

	private boolean existePersonaRegistrada(Persona personaNueva) throws PersonaDuplicadaException {
		if (this.personas.contains(personaNueva)) {
			throw new PersonaDuplicadaException();
		}
		return false;
	}

	public void agregarBanco(Banco banco) throws BancoNoEncontradoExcecption {
		if (!(existeBancoRegistrado(banco))) {
			this.bancos.add(banco);
		}

	}

	/*
	 * Este Metodo lanza las siguientes Excepciones NoSeEncuentraAtracadorException
	 * BancoNoEncontradoExcecption
	 * 
	 */

	private boolean existeBancoRegistrado(Banco banco) throws BancoNoEncontradoExcecption {
		if (this.bancos.contains(banco)) {
			throw new BancoNoEncontradoExcecption();
		}
		return false;
	}

	public void registrarAtraco(Integer dniAtracador, Integer idBanco)
			throws NoSeEncuentraAtracadorException, BancoNoEncontradoExcecption {

		Atracador atracador = buscarAtracadorPorDni(dniAtracador);
		Banco banco = buscarBancoPorId(idBanco);
		Atraco atraco = new Atraco(atracador, banco);

		Integer idBancoBuscado = banco.getIdBanco();
		// Se debe agregar un atraco al Mapa
		this.atracos.put(idBancoBuscado, atraco);

	}

	private Banco buscarBancoPorId(Integer idBanco) throws BancoNoEncontradoExcecption {
		for (Banco banco : bancos) {
			if (banco.getIdBanco().equals(idBanco)) {
				return banco;
			}
		}
		throw new BancoNoEncontradoExcecption();

	}

	private Atracador buscarAtracadorPorDni(Integer dniAtracador) throws NoSeEncuentraAtracadorException {
		for (Persona atracador : this.personas) {
			if (atracador.getDni().equals(dniAtracador)) {
				return (Atracador) atracador;
			}
		}
		throw new NoSeEncuentraAtracadorException();
	}

	// Si la clave no existe lanza ClaveInexistenteException
	public Atraco buscarAtracoPorClave(Integer claveAtraco) throws ClaveInexistenteException {
		Atraco atracoObtenido = this.atracos.get(claveAtraco);
		if (atracoObtenido != null) {
			return atracoObtenido;
		}
		throw new ClaveInexistenteException();
	}

//	public Vigilante obtenerElVigiladorDeUnAtraco(Integer claveAtraco) {
//
//		Vigilante vigilante;
//
//		return vigilante;
//
//	}

	public Set<Atracador> obtenerAtracadoresOrdenados() { // cambie la firma del metodo

		Set<Atracador> atracadoresOrdenadados = new TreeSet<Atracador>(new OrdenPorApodo());
		for (Persona atracador : this.personas) {
			if (atracador instanceof Atracador) {
				atracadoresOrdenadados.add((Atracador) atracador);
			}
		}

		return atracadoresOrdenadados;
	}

	public Integer cantidadDePersonasResgistradas() {
		return this.personas.size();
	}

	public Set<Vigilante> vigiantesOrdenPorApellido() {

		Set<Vigilante> vigilantesOrdenadados = new TreeSet<Vigilante>(new OrdenPorApellido());
		for (Persona vigilante : this.personas) {
			if (vigilante instanceof Vigilante) {
				vigilantesOrdenadados.add((Vigilante) vigilante);
			}
		}

		return vigilantesOrdenadados;
	}

}
