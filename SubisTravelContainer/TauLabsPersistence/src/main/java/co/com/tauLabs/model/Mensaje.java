package co.com.tauLabs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mensaje")
public class Mensaje implements Serializable, IEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mensaje")
	private Long id;

	private String asunto;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Lob
	private String mensaje;
	
	@Column(name="id_usuario_origen",nullable = false)
	private Long idUsuarioOrigen;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_origen",insertable = false, updatable = false)
	private Usuario usuarioOrigen;
	
	@Column(name="id_usuario_destino",nullable = false)
	private Long idUsuarioDestino;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_destino",insertable = false, updatable = false)
	private Usuario usuarioDestino;

	public Mensaje() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuarioOrigen() {
		return this.usuarioOrigen;
	}

	public void setUsuarioOrigen(Usuario usuarioOrigen) {
		this.usuarioOrigen = usuarioOrigen;
	}

	public Usuario getUsuarioDestino() {
		return this.usuarioDestino;
	}

	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
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