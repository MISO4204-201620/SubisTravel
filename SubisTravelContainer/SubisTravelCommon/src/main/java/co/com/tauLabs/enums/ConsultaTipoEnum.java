package co.com.tauLabs.enums;

public enum ConsultaTipoEnum {
	
	CONSULTA										("Consulta"),
	BUSQUEDA									("Busqueda");

	private String value;
	
	private ConsultaTipoEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
