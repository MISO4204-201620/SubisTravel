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
@Table(name="item")
public class Item implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private Long id;

	private String descripcion;

	private String estado;

	private Double valor;

	@Column(name="id_clasificacion")
	private Long idClasificacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_clasificacion",insertable=false,updatable=false)
	private Clasificacion clasificacion;

	@Column(name="id_tipo")
	private Long idTipo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo",insertable=false,updatable=false)
	private Tipo tipo;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Calificacion> calificaciones;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<CatalogoItem> catalogoItems;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Consulta> consultas;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Contenido> contenidos;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private List<Pregunta> preguntas;

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

	
	
}