package co.com.tauLabs.dto;

import java.io.Serializable;
import java.util.Date;

public class MensajeDTO implements Serializable	{

	private static final long serialVersionUID = -1648604903775735568L;

	//Campos de Mensaje
	private Long id;
	private String asunto;
	private String mensaje;
	private Date fecha;
	private Long idMensajeRelacionado;
	
	//Campos de usuario
	private Long idUsuarioOrigen;
	private Long idUsuarioDestino;
	private String nombreUsuarioOrigen;
	private String nombreUsuarioDestino;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombreUsuarioOrigen() {
		return nombreUsuarioOrigen;
	}
	public void setNombreUsuarioOrigen(String nombreUsuarioOrigen) {
		this.nombreUsuarioOrigen = nombreUsuarioOrigen;
	}
	public String getNombreUsuarioDestino() {
		return nombreUsuarioDestino;
	}
	public void setNombreUsuarioDestino(String nombreUsuarioDestino) {
		this.nombreUsuarioDestino = nombreUsuarioDestino;
	}
	public Long getIdMensajeRelacionado() {
		return idMensajeRelacionado;
	}
	public void setIdMensajeRelacionado(Long idMensajeRelacionado) {
		this.idMensajeRelacionado = idMensajeRelacionado;
	}
	public Long getIdUsuarioOrigen() {
		return idUsuarioOrigen;
	}
	public void setIdUsuarioOrigen(Long idUsuarioOrigen) {
		this.idUsuarioOrigen = idUsuarioOrigen;
	}
	public Long getIdUsuarioDestino() {
		return idUsuarioDestino;
	}
	public void setIdUsuarioDestino(Long idUsuarioDestino) {
		this.idUsuarioDestino = idUsuarioDestino;
	}


	
}
