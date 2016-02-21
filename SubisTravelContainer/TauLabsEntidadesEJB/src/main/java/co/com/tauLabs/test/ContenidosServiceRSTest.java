package co.com.tauLabs.test;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import co.com.tauLabs.model.Contenido;

public class ContenidosServiceRSTest {

	public static void main(String[] args) {
		try{	
		System.out
		.println("Iniciando test de servicios RS de Entidades");
					
			Client client = Client.create();
				
			/**********************
			 * Lista los contenidos de un item
			 *********************/
			
			WebResource web = client.resource("http://localhost:8182/SubisTravelWeb/services/contenidos/1");	
			List<Contenido> lstContenidos = web.get(new GenericType<List<Contenido>>() {});
			for (Contenido c : lstContenidos) {
				System.out.println(c.getId() + " " + c.getTitulo());
			}	

			
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
