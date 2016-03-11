package co.com.tauLabs.dto;

import java.io.Serializable;

public class ShoppingItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idItem;
	private Long idUser;
	private Long quantity;
	
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
