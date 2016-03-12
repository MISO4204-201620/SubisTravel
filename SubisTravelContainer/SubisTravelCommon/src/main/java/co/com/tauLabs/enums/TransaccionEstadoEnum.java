package co.com.tauLabs.enums;

public enum TransaccionEstadoEnum{

	CARRITO											("Carrito"),
	ELIMINADA										("Eliminada"),
	PROCESADA_VALIDA								("Procesada valida"),
	PROCESADA_ERRONEA								("Procesada erronea"),
	COMPLETADA										("Completada");	
	
	private String value;
	
	private TransaccionEstadoEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
		
}
