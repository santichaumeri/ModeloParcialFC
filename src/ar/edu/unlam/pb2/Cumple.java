package ar.edu.unlam.pb2;

public class Cumple implements Evento{
	
	private Usuario agasajado;
	private Usuario organizador; 

	public Cumple(Usuario organizador, Usuario agasajado) {
		this.setAgasajado(agasajado); 
		this.organizador = organizador; 
	}

	public Usuario getAgasajado() {
		return agasajado;
	}

	public void setAgasajado(Usuario agasajado) {
		this.agasajado = agasajado;
	}

	@Override
	public Usuario getOrganizador() {
		return this.organizador;
	}

}
