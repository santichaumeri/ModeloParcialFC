package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlanificadorDeEventos {

	private Set<Usuario> usuarios;

	public PlanificadorDeEventos() {
		super();
		this.usuarios = new HashSet<>();

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

	public void crear(Usuario usuario, Cumple cumple) {
		
		
	}









}
