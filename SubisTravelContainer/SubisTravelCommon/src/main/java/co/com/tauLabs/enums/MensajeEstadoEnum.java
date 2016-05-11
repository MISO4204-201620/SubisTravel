package co.com.tauLabs.enums;

public enum MensajeEstadoEnum {
	
	ACTIVO										("Activo"),
	ARCHIVADO									("Archivado"),
	ELIMINADO									("Eliminado");;	
	
	private String value;
	
	private MensajeEstadoEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
