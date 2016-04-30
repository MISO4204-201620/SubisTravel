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
	ENTIDADES_BY_ESTADO("entidades.byEstado"),
	CALIFICACIONES_BY_ITEM("calificaciones.byItem"),
	CALIFICACIONES_BY_CATALOG("calificaciones.byCatalogo"),
	CLASIFICACIONES_ALL("clasificaciones.all"),
	CATALOGOS_ALL("catalogos.all"),
	USUARIO_BY_EMAIL("usuario.byEmail"),
	USUARIO_BY_SOCIAL_ID("usuario.bySocialId"),
	USUARIO_CLIENTS_BY_ENTITY("usuario.clientsByEntity"),
	PREGUNTAS_BY_ITEM("preguntas.byItem"),
	PREGUNTAS_BY_CATALOG("preguntas.byCatalogo"),
	PREGUNTAS_BY_PREGUNTA_PADRE("preguntas.byPreguntaPadre"),
	TRANSACCIONES_BY_ITEM_BY_USER_BY_STATE("transacciones.byItembyUserByState"),
	PAQUETE_BY_ITEM_PAQUETE("paquete.byItemPaquete"),
	REPORTE_ITEMS_BY_USER_CONSULTADOS_BY_TIPO("reportes.detalleItemsPorIdUsuarioConsultadosPorTipoConsulta"),
	REPORTE_TEXTO_BUSCADO_BY_ITEM("reportes.palabrasBuscadasPorItem");
	
	private String value;
	
	private QueryName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
