package co.com.tauLabs.enums;

public enum EntidadEstadoEnum {
	
	REGISTRADA										("Registrada"),
	SOLICITUDBAJA									("SolicitudBaja"),
	BAJA								            ("Baja");	
	
	private String value;
	
	private EntidadEstadoEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
