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

	CONTENIDO_BY_ITEM("contenido.byItem"),
	ENTIDADES_BY_TIPO("entidades.byTipo"),
	CALIFICACIONES_BY_ITEM("calificaciones.byItem"),
	CALIFICACIONES_BY_CATALOG("calificaciones.byCatalogo"),
	CLASIFICACIONES_ALL("clasificaciones.all"),
	CATALOGOS_ALL("catalogos.all"),
	PREGUNTAS_BY_ITEM("preguntas.byItem"),
	PREGUNTAS_BY_CATALOG("preguntas.byCatalogo"),
	TRANSACCIONES_BY_ITEM_BY_USER_BY_STATE("transacciones.byItembyUserByState");
	
	private String value;
	
	private QueryName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
