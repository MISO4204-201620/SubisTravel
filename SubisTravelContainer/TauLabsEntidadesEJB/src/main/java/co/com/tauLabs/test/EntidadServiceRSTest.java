package co.com.tauLabs.test;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import co.com.tauLabs.model.Entidad;


public class EntidadServiceRSTest {

	public static void main(String[] args) {
		try{	
		System.out.println("Iniciando test de servicios RS de Entidades");
					
			Client client = Client.create();
	
			client.addFilter(new HTTPBasicAuthFilter("admin", "admin"));
			
			/**********************
			 * Recuperar una entidad
			 *********************/
			WebResource web = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades/2");
	
			Entidad entidad = web.get(Entidad.class);
			System.out.println("La entidad es: " + entidad.getNombre() + " "+ entidad.getNombre());
	
			System.out.println();
	
			/*******************
			 * Agregar una entidad
			 ******************/
			web = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades");
			Entidad nuevaEntidad = new Entidad();
			nuevaEntidad.setNombre("Ricardo");
	//		nuevaEntidad.setUsuarioCreacion("Gonzalez");
	//		nuevaEntidad.setUsuarioActualizacion("rgonzalez@mail.com");
	
			ClientResponse response = web.post(ClientResponse.class, nuevaEntidad);
	
			System.out.println("El código de respuesta en la inserción fue: "+ response.getStatus());
	
			if (response.getStatus() == 200) {
				Entidad ent = response.getEntity(Entidad.class);
				System.out.println("Nueva entidad: " + ent.getId() + " "+ ent.getNombre());
			}
	
			System.out.println();
	
			/*********************
			 * Modificar una entidad
			 ********************/
			web = client
					.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades/1");
			Entidad entidadModificada = entidad;// entidad recuperada anteriormente
			entidadModificada.setNombre("Juan");
	//		entidadModificada.setUsuarioCreacion("Perez");
	//		entidadModificada.setUsuarioActualizacion("jperez@mail.com");
	
			response = web.put(ClientResponse.class, entidadModificada);
	
			System.out.println("El código de respuesta de la modificación fue: "
					+ response.getStatus());
	
			if (response.getStatus() == 200) {
				Entidad ent = response.getEntity(Entidad.class);
				System.out.println("Nueva entidad: " + ent.getId() + " "+ ent.getNombre());
			}
	
			System.out.println();
	
			/********************
			 * Eliminar una entidad
			 *******************/
			WebResource wr = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades/32");
	
			response = wr.delete(ClientResponse.class);
			
			System.out.println("El código de respuesta de la eliminación fue: "+ response.getStatus());
			
			if (response.getStatus() == 404) {
				System.out.println("La entidad a eliminar NO existe");
			} else {
				System.out.println("La entidad fue eliminada con éxito");
			}
	
			/********************
			 * Listar todas las Entidads
			 *******************/
			web = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades");
	
			List<Entidad> entidads = web.get(new GenericType<List<Entidad>>() {
			});
	
			for (Entidad p : entidads) {
				System.out.println(p.getId() + " " + p.getNombre());
			}	
	
			System.out.println("Fin test de servicios RS de Entidades");
			}catch(Exception e){
				System.out.println(e);
			}
	}

}
