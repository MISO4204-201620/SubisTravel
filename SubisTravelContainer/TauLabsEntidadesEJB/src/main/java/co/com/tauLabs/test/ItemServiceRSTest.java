package co.com.tauLabs.test;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.model.Item;

public class ItemServiceRSTest {

	public static void main(String[] args) {
		try{	
		System.out.println("Iniciando test de servicios RS de Entidades");
					
			Client client = Client.create();
				
			/**********************
			 * Recuperar una entidad
			 *********************/
			
			WebResource web = client.resource("http://ec2-54-191-125-225.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/items");
			FilterDTO filtros = new FilterDTO();
			filtros.setProviders(new ArrayList<String>());
			filtros.getProviders().add("1");
			filtros.getProviders().add("2");
			filtros.setClasifications(new ArrayList<String>());
			filtros.getClasifications().add("1");
			filtros.getClasifications().add("2");
			filtros.setMinValue(0.0);
			filtros.setMaxValue(12000.0);
	
			List<Item> entidads = web.post(new GenericType<List<Item>>() {},filtros);
			for (Item item : entidads) {
				System.out.println(item.getDescripcion());
			}
//			System.out.println();
//			
//			WebResource web = client.resource("http://localhost:8182/SubisTravelWeb/services/items");
//			FiltroDTO filtros = new FiltroDTO();
//			filtros.setProviders(new HashSet<String>());
//			filtros.getProviders().add("ServioTechnologies");
//			filtros.getProviders().add("ZubCars");
//	
//			List<Item> entidads = web.get(new GenericType<List<Item>>() {});
			
			System.out.println();
			
//			WebResource web = client.resource("http://localhost:8182/SubisTravelWeb/services/items/2");
//	
//			Entidad entidad = web.get(Entidad.class);
//			System.out.println("La entidad es: " + entidad.getNombre() + " "+ entidad.getNombre());
//	
//			System.out.println();
//	
//			/*******************
//			 * Agregar una entidad
//			 ******************/
//			web = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades");
//			Entidad nuevaEntidad = new Entidad();
//			nuevaEntidad.setNombre("Ricardo");
//	//		nuevaEntidad.setUsuarioCreacion("Gonzalez");
//	//		nuevaEntidad.setUsuarioActualizacion("rgonzalez@mail.com");
//	
//			ClientResponse response = web.post(ClientResponse.class, nuevaEntidad);
//	
//			System.out.println("El código de respuesta en la inserción fue: "+ response.getStatus());
//	
//			if (response.getStatus() == 200) {
//				Entidad ent = response.getEntity(Entidad.class);
//				System.out.println("Nueva entidad: " + ent.getId() + " "+ ent.getNombre());
//			}
//	
//			System.out.println();
//	
//			/*********************
//			 * Modificar una entidad
//			 ********************/
//			web = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades/1");
//			Entidad entidadModificada = entidad;// entidad recuperada anteriormente
//			entidadModificada.setNombre("Juan");
//	//		entidadModificada.setUsuarioCreacion("Perez");
//	//		entidadModificada.setUsuarioActualizacion("jperez@mail.com");
//	
//			response = web.post(ClientResponse.class, entidadModificada);
//	
//			System.out.println("El código de respuesta de la modificación fue: "
//					+ response.getStatus());
//	
//			if (response.getStatus() == 200) {
//				Entidad ent = response.getEntity(Entidad.class);
//				System.out.println("Nueva entidad: " + ent.getId() + " "+ ent.getNombre());
//			}
//	
//			System.out.println();
//	
//			/********************
//			 * Eliminar una entidad
//			 *******************/
//			WebResource wr = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades/32");
//	
//			response = wr.delete(ClientResponse.class);
//			
//			System.out.println("El código de respuesta de la eliminación fue: "+ response.getStatus());
//			
//			if (response.getStatus() == 404) {
//				System.out.println("La entidad a eliminar NO existe");
//			} else {
//				System.out.println("La entidad fue eliminada con éxito");
//			}
//	
//			/********************
//			 * Listar todas las Entidads
//			 *******************/
//			web = client.resource("http://ec2-54-213-44-92.us-west-2.compute.amazonaws.com:8080/SubisTravelWeb/services/entidades");
//	
//			List<Entidad> entidads = web.get(new GenericType<List<Entidad>>() {});
//	
//			for (Entidad p : entidads) {
//				System.out.println(p.getId() + " " + p.getNombre());
//			}	
//	
//			System.out.println("Fin test de servicios RS de Entidades");
//			}catch(Exception e){
//				System.out.println(e);
//			}
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
