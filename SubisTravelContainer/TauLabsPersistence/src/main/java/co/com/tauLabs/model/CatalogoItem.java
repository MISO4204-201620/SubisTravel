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
@Table(name="catalogo_item")
public class CatalogoItem implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_catalogo_item")
	private Long id;

	private Byte eliminado;

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

	public CatalogoItem() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
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
	
}