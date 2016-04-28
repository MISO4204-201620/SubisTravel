package co.com.tauLabs.enums;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;

public enum ServiciosActivosEnum {
	COMMENTS_AND_RATINGS,
	BASIC,
	INTERMEDIATE,
	PRO;

	// guarda un breve nombre dado a un enumerador.
	private static java.util.Properties props;
	private static Map<String,Boolean> valores = null;

	private static void inicializarValores() throws ApplicationException {
		try {
			valores = new HashMap<String, Boolean>();
			if (props == null)
				props = new java.util.Properties();
			props.load(ServiciosActivosEnum.class.getResourceAsStream("serviciosActivos.properties"));
			for (ServiciosActivosEnum ae : ServiciosActivosEnum.values()) {
				props.get(ae);
				if (props.get(ae.toString()) != null) {
					valores.put(ae.toString(), Boolean.valueOf(props.get(ae.toString()).toString()));
				} else {
					valores.put(ae.toString(), false);
				}
			} // if
		} catch (Exception ex) {
			System.out.println("Error cargando propiedades, causa: "+ex.getCause());
		}
	}

	public Boolean getValue() {
		try {

			if (valores == null) {
				inicializarValores();
			}
		} catch (Exception io) {
			System.out.println("Error al cargar propiedades");
		}
		return valores.get(this.toString());
	}

}
