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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CATALOGO", schema="SubisDB")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalogo implements Serializable, IEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_catalogo")
	private Long id;

	private String descripcion;

	private String estado;

	private String nombre;

	private Double valor;
	
	@Column(name="id_usuario")
	private Long idUsuario;
	
	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario",insertable = false, updatable=false)
	private Usuario usuario;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="catalogo")
	private List<Calificacion> calificaciones;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="catalogo")
	private List<CatalogoItem> catalogoItems;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="catalogo")
	private List<Consulta> consultas;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="catalogo")
	private List<Contenido> contenidos;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="catalogo")
	private List<Pregunta> preguntas;

	public Catalogo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CatalogoItem> getCatalogoItems() {
		return this.catalogoItems;
	}

	public void setCatalogoItems(List<CatalogoItem> catalogoItems) {
		this.catalogoItems = catalogoItems;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Contenido> getContenidos() {
		return this.contenidos;
	}

	public void setContenidos(List<Contenido> contenidos) {
		this.contenidos = contenidos;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}