package ar.edu.unlam.pb2;

import java.util.Objects;

public class Usuario {

	private String mail;
	private Integer edad;
	private String nombre;

	public Usuario(String mail, String nombre, Integer edad) {
		this.mail = mail; 
		this.nombre = nombre; 
		this.edad = edad; 
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(mail, other.mail);
	}
	
	

}
