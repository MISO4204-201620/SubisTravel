package co.com.tauLabs.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="PREGUNTA", schema="SubisDB")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pregunta implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pregunta")
	private Long id;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name="id_catalogo")
	private Long idCatalogo;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_catalogo",insertable = false, updatable=false)
	private Catalogo catalogo;
	
	@Column(name="id_item")
	private Long idItem;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item",insertable = false, updatable=false)
	private Item item;
	
	@Column(name="id_usuario")
	private Long idUsuario;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario",insertable = false, updatable=false)
	private Usuario usuario;

	@Column(name="id_pregunta_padre")
	private Long idPreguntaPadre;
	
	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pregunta_padre",insertable = false, updatable=false)
	private Pregunta preguntaPadre;
	
	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="preguntaPadre")
	private List<Pregunta> preguntasHijas;
	
	public Pregunta() {
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Pregunta getPreguntaPadre() {
		return preguntaPadre;
	}

	public void setPreguntaPadre(Pregunta preguntaPadre) {
		this.preguntaPadre = preguntaPadre;
	}
	
	public Long getIdPreguntaPadre() {
		return idPreguntaPadre;
	}

	public void setIdPreguntaPadre(Long idPreguntaPadre) {
		this.idPreguntaPadre = idPreguntaPadre;
	}

	public List<Pregunta> getPreguntasHijas() {
		return preguntasHijas;
	}

	public void setPreguntasHijas(List<Pregunta> preguntasHijas) {
		this.preguntasHijas = preguntasHijas;
	}
	
}