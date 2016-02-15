package co.com.tauLabs.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.service.IEntidadService;

public class PersonaServiceTest {

	private IEntidadService personaService;

	@Before
	public void setUp() throws Exception {
		try{
			EJBContainer contenedor = EJBContainer.createEJBContainer();
			personaService = (IEntidadService) contenedor.getContext().lookup("java:global/ejb-app/classesejb/EntidadService");
		}catch(Exception e ){
			System.out.println(e);
		}
	}

//	@Test
	public void testEJBPersonaService() {
		System.out.println("Iniciando test EJB PersonaService");
		
		assertTrue(personaService != null);
		
		//assertEquals(3, personaService.listarPersonas().size());
		try {
			System.out.println("LOLASO");
			personaService.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.desplegarPersonas(personaService.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin test EJB PersonaService");
	}
	
	private void desplegarPersonas(List<Entidad> personas){
		for (Entidad persona : personas) {
			System.out.println(persona);
		}
	}
}
