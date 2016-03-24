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
@Table(name="ITEM", schema="SubisDB")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private Long id;

	private String nombre;

	private String descripcion;

	private String imagen;

	private String estado;

	private Double valor;
	
	private Float promedioCalificacion;

	@Column(name="id_clasificacion")
	private Long idClasificacion;
	
	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_clasificacion",insertable=false,updatable=false)
	private Clasificacion clasificacion;

	@Column(name="id_entidad")
	private Long idEntidad;
	
	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entidad",insertable=false,updatable=false)
	private Entidad entidad;

	@Column(name="id_tipo")
	private Long idTipo;

	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo",insertable=false,updatable=false)
	private Tipo tipo;

	
	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Calificacion> calificaciones;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<CatalogoItem> catalogoItems;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")	
	private List<Consulta> consultas;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Contenido> contenidos;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Pregunta> preguntas;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Transaccion> transacciones;

	public Item() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Clasificacion getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Transaccion> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public Long getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(Long idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public Long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Float getPromedioCalificacion() {
		return promedioCalificacion;
	}

	public void setPromedioCalificacion(Float promedioCalificacion) {
		this.promedioCalificacion = promedioCalificacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}