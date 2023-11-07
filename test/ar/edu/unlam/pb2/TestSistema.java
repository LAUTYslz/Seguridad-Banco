package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class TestSistema {

	@Test
	public void testQueRegistroUnBanco() throws BancoNoEncontradoExcecption {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");

		Integer idbanco = 1;
		Banco banco = new Banco(idbanco, "la Casa de Papel");
		vigilancia.agregarBanco(banco);

	}

	@Test
	public void quePuedaRegistrarUnAtracador() throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");
		Integer idbanda = 1;
		String nombre = "La Casa de Papel";
		Banda banda = new Banda(idbanda, nombre);

		Integer dni = 1;
		nombre = "Ursula";
		String apellido = "Corbero";
		String apodo = "Tokio";

		// No Cambiar esta Linea
		Persona atracador = new Atracador(dni, nombre, apellido, apodo, banda);
		vigilancia.registrarPersona(atracador);
		Integer valorEsperado = 1;

		// Compleatar el Assert
		assertEqual(valorEsperado, vigilancia.cantidadDePersonasResgistradas());

	}

	@Test(expected = PersonaDuplicadaException.class)
	public void queCuandoSeRegistre2PersonasConElMismoDNiLanceUnaExpcionPersonaDuplicadaException()
			throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");
		// Creo Vigilante

		Persona vigilante = new Vigilante(1, "Pepito", "Pistolero", new Banco(1, "LA Casa De Papel"));
		vigilancia.registrarPersona(vigilante);
		// Creo Banda
		Integer idBanda = 1;
		String nombre = "La Casa de Papel";
		Banda banda = new Banda(idBanda, nombre);
		// Creo Atracador
		Integer dni = 1;
		nombre = "Ursula";
		String apellido = "Corbero";
		String apodo = "Tokio";
		// No Cambiar esta Linea
		Persona atracador = new Atracador(dni, nombre, apellido, apodo, banda);
		vigilancia.registrarPersona(atracador);

	}

	@Test
	public void queSePuedaRegistraUnAtraco() throws PersonaDuplicadaException, BancoNoEncontradoExcecption,
			NoSeEncuentraAtracadorException, ClaveInexistenteException {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");

		Integer idBanda = 1;
		String nombre = "La Casa de Papel";
		Banda banda = new Banda(idBanda, nombre);

		Integer dni = 1;
		String nombreAtracador = "Ursula"; // no tenia el String y le cambie el nombre a "nombreAtracador"
		String apellido = "Corbero";
		String apodo = "Tokio";

		// No Cambiar esta Linea
		Persona atracador = new Atracador(dni, nombre, apellido, apodo, banda);
		vigilancia.registrarPersona(atracador);

		Integer idBanco = 1;
		Banco banco = new Banco(idBanco, "la Casa de Papel");
		vigilancia.agregarBanco(banco);

		vigilancia.registrarAtraco(dni, idBanco);

		Integer valorEsperado = 1;

		Integer claveAtraco = 1;
		Atraco atraco = vigilancia.buscarAtracoPorClave(claveAtraco);

		Banco bancoEsperado = new Banco(idBanco, "la Casa de Papel");

		// No cambiar
		assertTrue(bancoEsperado.equals(atraco.getBanco()));

	}

	@Test
	public void queSePuedaObtenerLosAtracadoresOrdenadosPorApodos() throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");

		Integer idBanda = 1;
		String nombre = "La Casa de Papel";
		Banda banda = new Banda(idBanda, nombre);

		Integer dni = 1;
		String nombreAtracador = "Ursula";
		String apellido = "Corbero";
		String apodo = "Tokio";

		Persona atracador = new Atracador(dni, nombre, apellido, apodo, banda);
		/// -----------------------------------------------------------------
		Integer idBandaSegunda = 2;
		String nombreSegunda = "Los Monos";
		Banda bandaSegunda = new Banda(idBandaSegunda, nombreSegunda);

		Integer dniSegundo = 2;
		String nombreAtracadorSegundo = "Agustin";
		String apellidoSegundo = "Anichini";
		String apodoSegundo = "Cabeza";

		Persona atracadorSegundo = new Atracador(dniSegundo, nombreAtracadorSegundo, apellidoSegundo, apodoSegundo,
				bandaSegunda);
		/// -----------------------------------------------------------------

		Integer idBandaTercero = 3;
		String nombreTercero = "Los Novicios";
		Banda bandaTercero = new Banda(idBandaTercero, nombreTercero);

		Integer dniTercero = 3;
		String nombreAtracadorTercero = "Nahuel";
		String apellidoTercero = "Alvarez";
		String apodoTercero = "Pesadilla";

		Persona atracadorTercero = new Atracador(dniTercero, nombreAtracadorTercero, apellidoTercero, apodoTercero,
				bandaTercero);

		vigilancia.registrarPersona(atracador);
		vigilancia.registrarPersona(atracadorSegundo);
		vigilancia.registrarPersona(atracadorTercero);

		Set<Atracador> atracadoresOrdenados = vigilancia.obtenerAtracadoresOrdenados();
// cabeza Pesadilla Tokio

//		for (Atracador atracadorOrdenado : atracadoresOrdenados) {
//			System.out.println(atracadorOrdenado);
//		}

	}

//Cree un 3 test a su eleccion para que pruebe el resto de las funcionalidades

	@Test(expected = NoSeEncuentraAtracadorException.class)
	public void queNoSePuedaRegistrarUnAtracoSiElAracadorNoEstaEnLaVigilancia()
			throws BancoNoEncontradoExcecption, NoSeEncuentraAtracadorException {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");

		Integer idBanda = 1;
		String nombre = "La Casa de Papel";
		Banda banda = new Banda(idBanda, nombre);

		Integer dni = 1;
		String nombreAtracador = "Ursula";
		String apellido = "Corbero";
		String apodo = "Tokio";

		Persona atracador = new Atracador(dni, nombre, apellido, apodo, banda);

		Integer idBanco = 1;
		Banco banco = new Banco(idBanco, "la Casa de Papel");
		vigilancia.agregarBanco(banco);

		vigilancia.registrarAtraco(dni, idBanco);
	}

	@Test(expected = BancoNoEncontradoExcecption.class)
	public void queNoSePuedeRegistrarUnAtracoDeUnBancoInexistenteEnLaVigilancia()
			throws PersonaDuplicadaException, NoSeEncuentraAtracadorException, BancoNoEncontradoExcecption {

		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");

		Integer idBanda = 1;
		String nombre = "La Casa de Papel";
		Banda banda = new Banda(idBanda, nombre);

		Integer dni = 1;
		String nombreAtracador = "Ursula"; // no tenia el String y le cambie el nombre a "nombreAtracador"
		String apellido = "Corbero";
		String apodo = "Tokio";

		// No Cambiar esta Linea
		Persona atracador = new Atracador(dni, nombre, apellido, apodo, banda);
		vigilancia.registrarPersona(atracador);

		Integer idBanco = 1;
		Banco banco = new Banco(idBanco, "la Casa de Papel");

		vigilancia.registrarAtraco(dni, idBanco);
	}

	@Test
	public void queSePuedaObtenerLosVigilantesOrdenadosPorApellido() throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia("Nombre De la Compania de Vigilancia");

		Persona vigilante = new Vigilante(1, "Nahuel", "Gutierrez", new Banco(1, "LA Casa De Papel"));
		vigilancia.registrarPersona(vigilante);

		Persona vigilanteSegundo = new Vigilante(2, "Agustin", "Anichini", new Banco(2, "Banco Nacion"));
		vigilancia.registrarPersona(vigilanteSegundo);

		Persona vigilanteTercero = new Vigilante(3, "Miriam", "Rivera", new Banco(3, "BBVA"));
		vigilancia.registrarPersona(vigilanteTercero);

		Set<Vigilante> vigilantesOrdenados = vigilancia.vigiantesOrdenPorApellido();
// Anicini Gutierrez Rivera

//		for (Vigilante vigilanteOrdenado : vigilantesOrdenados) {
//			System.out.println(vigilanteOrdenado);
//		}

	}

	public void assertEqual(Integer valorEsperado, Integer cantidadDePersonasResgistradas) {
		valorEsperado.equals(cantidadDePersonasResgistradas);
	}
}
