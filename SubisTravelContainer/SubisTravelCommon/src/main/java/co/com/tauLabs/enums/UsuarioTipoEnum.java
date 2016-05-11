package co.com.tauLabs.enums;

public enum UsuarioTipoEnum {
	
	CLIENTE										("Cliente"),
	PROVEEDOR									("Empresa"),
	ADMINISTRADOR								            ("Administrador");	
	
	private String value;
	
	private UsuarioTipoEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
