/**
 * 
 */
package co.com.tauLabs.constant;

/**
 * Determina los nombres de los Named Query
 * 
 * @author Servio Andrés Pantoja Rosero
 * @since 15/3/2015
 */
public enum QueryName {

	CONTENIDO_BY_ITEM("contenido.byItem");
	
	
	private String value;
	
	private QueryName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
