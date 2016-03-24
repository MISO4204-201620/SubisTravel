package co.com.tauLabs.enums;

public enum ItemEstadoEnum {

	CREADO											("Creado"),
	PUBLICADO										("Publicado"),
	ELIMINADO								        ("Eliminado");	
	
	private String value;
	
	private ItemEstadoEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
