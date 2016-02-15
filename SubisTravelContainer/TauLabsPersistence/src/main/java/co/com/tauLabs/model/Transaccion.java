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
@Table(name="transaccion")
public class Transaccion implements Serializable, IEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transaccion")
	private Long id;

	private Integer cantidad;

	private Byte eliminado;//TODO: Para que utilizariamos este estado

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private Double valor;

	@Column(name="id_item",nullable=false)
	private Long idItem;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item",insertable=false,updatable=false)
	private Item item;

	@Column(name="id_usuario",nullable=false)
	private Long idUsuario;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario",insertable = false,updatable=false)
	private Usuario usuario;

	public Transaccion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Byte getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
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

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

}