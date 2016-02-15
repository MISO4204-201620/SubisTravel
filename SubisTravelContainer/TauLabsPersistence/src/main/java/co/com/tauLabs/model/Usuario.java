package co.com.tauLabs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ususario")
public class Usuario implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;

	private String email;

	private String estado;

	private String login;

	private String password;

	@Column(name="id_entidad",nullable = false)
	private Long idEntidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entidad",insertable=false,updatable=false)
	private Entidad entidad;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
	private List<Calificacion> calificaciones;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
	private List<Catalogo> catalogos;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuarioOrigen")
	private List<Mensaje> mensajesOrigen;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuarioDestino")
	private List<Mensaje> mensajesDestino;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
	private List<Pregunta> preguntas;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
	private List<RolUsuario> rolesUsuario;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="usuario")
	private List<Transaccion> transacciones;

	public Usuario() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<Catalogo> getCatalogos() {
		return this.catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public List<Mensaje> getMensajesOrigen() {
		return this.mensajesOrigen;
	}

	public void setMensajesOrigen(List<Mensaje> mensajesOrigen) {
		this.mensajesOrigen = mensajesOrigen;
	}

	public List<Mensaje> getMensajesDestino() {
		return this.mensajesDestino;
	}

	public void setMensajesDestino(List<Mensaje> mensajesDestino) {
		this.mensajesDestino = mensajesDestino;
	}
	
	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<RolUsuario> getRolesUsuario() {
		return this.rolesUsuario;
	}

	public void setRolesUsuario(List<RolUsuario> rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

	public List<Transaccion> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

}