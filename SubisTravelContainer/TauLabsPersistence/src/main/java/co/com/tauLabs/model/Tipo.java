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
@Table(name="TIPO", schema="SubisDB")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tipo implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private Long id;

	private String estado;

	private String nombre;
	
	@Column(name="id_tipo_padre")
	private Long idTipoPadre;

	@XmlTransient
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_padre",insertable=false,updatable=false)
	private Tipo tipoPadre;

	@XmlTransient
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tipoPadre")
	private List<Tipo> tipos;
	
	@XmlTransient
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tipo")
	private List<Contenido> contenidos;
	
	@XmlTransient
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tipo")
	private List<Entidad> entidades;
	
	@XmlTransient
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tipo")
	private List<Item> items;

	public Tipo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Contenido> getContenidos() {
		return this.contenidos;
	}

	public void setContenidos(List<Contenido> contenidos) {
		this.contenidos = contenidos;
	}

	public List<Entidad> getEntidades() {
		return this.entidades;
	}

	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Tipo getTipoPadre() {
		return this.tipoPadre;
	}

	public void setTipoPadre(Tipo tipoPadre) {
		this.tipoPadre = tipoPadre;
	}

	public List<Tipo> getTipos() {
		return this.tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}


}