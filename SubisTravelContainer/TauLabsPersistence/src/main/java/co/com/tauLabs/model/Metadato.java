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
@Table(name="METADATO", schema="SubisDB")
public class Metadato implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_metadato")
	private Long id;


	@Column(name="id_item")
	private Long idItem;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item",insertable=false,updatable=false)
	private Item item;

	@Column(name="llave")
	private String llave;

	@Column(name="valor")
	private String valor;
	
	public Metadato() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}



	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
}