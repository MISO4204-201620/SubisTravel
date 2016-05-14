package interceptors;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class QrInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object seguimientoMetodo(InvocationContext invocationContext) throws Exception {
		try {

			invocationContext.getTarget();
			Object o = invocationContext.proceed();
			String json = o.toString();
			
			json = json.substring(0, json.length()-2) + ",\"qr\":\"asdadasdasd\"" + json.substring(json.length()-2, json.length());
			return json; // que continue la secuencia
		} catch (Exception e) {

			throw new Exception("Error validando información del formulario, causa: " + e.getMessage());
		}

	}

}
