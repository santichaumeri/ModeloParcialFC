package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlanificadorDeEventos {

	private Set<Usuario> usuarios;
	private Map<String, Evento> eventos;

	public PlanificadorDeEventos() {
		super();
		this.usuarios = new HashSet<>();
		this.eventos = new HashMap<>(); 
	}

	public void add(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public Usuario getUsuario(String mail) {
		for (Usuario usuario : usuarios) {
			if (usuario.getMail().equals(mail)) {
				return usuario;
			}
		}
		return null;
	}


	public Integer getCantidadDeUsuarios() {
		return this.usuarios.size();
	}

//	public void crear(Usuario organizador, Cumple cumple, String nombreEvento) {
//		
//		this.eventos.put(nombreEvento, cumple);
//	}
	
	public void crear(Cumple cumple, String nombreEvento) {
		this.eventos.put(nombreEvento, cumple);
		
	}
	
	public Integer getCantidadDeEventos() {
		return this.eventos.size();
	}

	public Integer getCantidadDeCumpleanios() {
		int contCumples = 0;
		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			String key = entry.getKey();
			Evento val = entry.getValue();
			
			if (val instanceof Cumple) {
				contCumples++; 
			}
		}
		
		return contCumples++;
	}
	
	public Integer getCantidadDeCasamientos() {
		int contCasam = 0;
		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			String key = entry.getKey();
			Evento val = entry.getValue();
			
			if (val instanceof Casamiento) {
				contCasam++;
			}
		}
		return contCasam;
	}

	public Evento getEvento(String nombreDelEvento) {
		for (Map.Entry<String, Evento> entry : eventos.entrySet()) {
			String key = entry.getKey();
			Evento val = entry.getValue();
			
			if (key.equals(nombreDelEvento)) {
				return val;
			}
			
		}
		
		return null;
	}

	public void crear(Usuario usuario, String nombreDelEvento) {
		
		
	}















}
