package co.com.tauLabs.dto;

import java.io.Serializable;

public class SessionClientDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idEntity;
	private Long idType;
	
	public Long getIdEntity() {
		return idEntity;
	}
	public void setIdEntity(Long idEntity) {
		this.idEntity = idEntity;
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	
}
