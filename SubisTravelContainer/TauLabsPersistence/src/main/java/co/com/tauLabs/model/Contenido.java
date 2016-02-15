package co.com.tauLabs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contenido")
public class Contenido implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contenido")
	private Long id;

	private String descripcion;

	private Byte orden;

	private String titulo;

	private String url;

	@Column(name="id_catalogo")
	private Long idCatalogo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_catalogo",insertable=false,updatable=false)
	private Catalogo catalogo;

	@Column(name="id_item")
	private Long idItem;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item",insertable=false,updatable=false)
	private Item item;

	@Column(name="id_tipo")
	private Long idTipo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo",insertable=false,updatable=false)
	private Tipo tipo;

	public Contenido() {
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

	public Byte getOrden() {
		return this.orden;
	}

	public void setOrden(Byte orden) {
		this.orden = orden;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Long getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

}