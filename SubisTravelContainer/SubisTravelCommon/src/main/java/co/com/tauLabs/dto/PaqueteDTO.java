package co.com.tauLabs.dto;

import java.io.Serializable;
import java.util.List;

public class PaqueteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private Long idItemPaquete; 
	private List<Long> idsItemsIncluidos;
	private Object itemPaquete;
	private List<Object> itemsIncluidos;
	
	public Long getIdItemPaquete() {
		return idItemPaquete;
	}
	public void setIdItemPaquete(Long idItemPaquete) {
		this.idItemPaquete = idItemPaquete;
	}
	public List<Long> getIdsItemsIncluidos() {
		return idsItemsIncluidos;
	}
	public void setIdsItemsIncluidos(List<Long> idsItemsIncluidos) {
		this.idsItemsIncluidos = idsItemsIncluidos;
	}
	public Object getItemPaquete() {
		return itemPaquete;
	}
	public void setItemPaquete(Object itemPaquete) {
		this.itemPaquete = itemPaquete;
	}
	public List<Object> getItemsIncluidos() {
		return itemsIncluidos;
	}
	public void setItemsIncluidos(List<Object> itemsIncluidos) {
		this.itemsIncluidos = itemsIncluidos;
	}
	
	
	
}
