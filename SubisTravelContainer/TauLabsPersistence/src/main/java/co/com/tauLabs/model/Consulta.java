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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CONSULTA", schema="SubisDB")
public class Consulta implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_consulta")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
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

	@Column(name="id_busqueda")
	private Long idBusqueda;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_busqueda",insertable=false,updatable=false)
	private Busqueda busqueda;
	
	@Column(name="tipo_consulta")
	private String tipoConsulta;
	
	public Consulta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdBusqueda() {
		return idBusqueda;
	}

	public void setIdBusqueda(Long idBusqueda) {
		this.idBusqueda = idBusqueda;
	}

	public Busqueda getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

}