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
@Table(name="PAQUETE", schema="SubisDB")
public class Paquete implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paquete")
	private Long id;


	@Column(name="id_item_paquete")
	private Long idItemPaquete;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item_paquete",insertable=false,updatable=false)
	private Item itemPaquete;

	@Column(name="id_item_incluido")
	private Long idItemIncluido;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item_incluido",insertable=false,updatable=false)
	private Item itemIncluido;

	public Paquete() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Item getItemPaquete() {
		return this.itemPaquete;
	}

	public void setItemPaquete(Item itemPaquete) {
		this.itemPaquete = itemPaquete;
	}

	public Item getItemIncluido() {
		return this.itemIncluido;
	}

	public void setItemIncluido(Item itemIncluido) {
		this.itemIncluido = itemIncluido;
	}

	public Long getIdItemPaquete() {
		return idItemPaquete;
	}

	public void setIdItemPaquete(Long idItemPaquete) {
		this.idItemPaquete = idItemPaquete;
	}

	public Long getIdItemIncluido() {
		return idItemIncluido;
	}

	public void setIdItemIncluido(Long idItemIncluido) {
		this.idItemIncluido = idItemIncluido;
	}
	
}