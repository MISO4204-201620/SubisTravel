package co.com.tauLabs.dto;

import java.io.Serializable;
import java.util.List;

public class PaymentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Long> idsTransacction;

	public List<Long> getIdsTransacction() {
		return idsTransacction;
	}

	public void setIdsTransacction(List<Long> idsTransacction) {
		this.idsTransacction = idsTransacction;
	}
	
}
