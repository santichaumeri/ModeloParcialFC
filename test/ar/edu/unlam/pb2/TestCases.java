package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {
	
	
	@Test
	public void queSePuedaCrearUnCumpleanios() {
		// Preparación
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi", nombreEvento = "El cumple de Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 2, cantidadDeEventosEsperados = 1, cantidadDeCumpleaniosEsperados = 1, cantidadDeCasamientosEsperados = 0;
		
		// Ejecución
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador));
		principal.crear(principal.getUsuario(mailOrganizador), new Cumple((Agasajado) new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado)));
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador), principal.getEvento("El cumple de Lionel Messi").getOrganizador());
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	
	@Test
	public void queSePuedaCrearUnCasamiento() {
		// Preparación
		final String mailOrganizador = "roberto@galan.com", nombreOrganizador = "Roberto Galan", mailAgasajado1 = "luli@salazar.com", nombreAgasajado1 = "Luciana Zalazar", mailAgasajado2 = "rodrigo@redrado.com", nombreAgasajado2 = "Rodrigo Redrado", nombreDelEvento = "El casamiento de Luli y Rodri";
		final Integer edadOrganizador = 101, edadAgasajado1 = 36, edadAgasajado2 = 43;
		final Integer cantidadDeUsuariosEsperados = 2, cantidadDeEventosEsperados = 1, cantidadDeCumpleaniosEsperados = 1, cantidadDeCasamientosEsperados = 0;
		
		// Ejecución
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador));
		principal.add(new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1));
		principal.add(new Usuario(mailAgasajado2, nombreAgasajado2, edadAgasajado2));
		
		principal.crear(principal.getUsuario(mailOrganizador), nombreDelEvento);
		principal.getEvento(nombreDelEvento).add((Agasajado)new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1));
		principal.getEvento(nombreDelEvento).add((Agasajado)new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1));		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador), principal.getEvento("El cumple de Lionel Messi").getOrganizador());
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	/*
	@Test
	public void queSePuedaInvitarGenteAUnCumpleanios() {
		// Preparación
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 4, cantidadDeInvitadosEsperados = 2;
		
		// Ejecución
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador));
		principal.add(new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36));
		principal.add(new Usuario("kmbappe@second.com", "Kylian Mbapee", 24));
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		Cumple elCumpleDeLeo = new Cumple((Agasajado)new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado));
		principal.crear(organizadorDelEvento, elCumpleDeLeo);
		principal.invitar(elCumpleDeLeo, new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36));
		principal.invitar(elCumpleDeLeo, new Usuario("kmbappe@second.com", "Kylian Mbapee", 24));
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getCantidadDeInvitados());
	}
	
	@Test
	public void queUnInvitadoPuedaConfirarSuAsistencia () {
		// Preparación
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 4, cantidadDeInvitadosEsperados = 2, cantidadDeInvitadosConfirmados = 1;
		Usuario elKun = new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36);
		Usuario elSegundo = new Usuario("kmbappe@second.com", "Kylian Mbapee", 24);
		
		// Ejecución
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador));
		principal.add(elKun);
		principal.add(elSegundo);
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		
		Usuario agasajado = new Agasajado(mailAgasajado, nombreAgasajado, edadAgasajado));
		principal.crear(organizadorDelEvento, new Cumple(agasajado);
		principal.invitar(elCumpleDeLeo, elKun);
		principal.invitar(elCumpleDeLeo, elSegundo);
		principal.confirmar(elCumpleDeLeo, elKun);
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getCantidadDeInvitados());
		assertEquals(cantidadDeInvitadosConfirmados, principal.getCantidadDeInvitadosConfirmados());
	}
*/
}
