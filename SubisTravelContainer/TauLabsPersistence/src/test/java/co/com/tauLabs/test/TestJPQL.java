//package co.com.tauLabs.test;
//
//import static org.junit.Assert.assertTrue;
//
//import javax.ejb.embeddable.EJBContainer;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.BeforeClass;
//
//public class TestJPQL {
//
//	static EntityManager em = null;
//	static EntityTransaction tx = null;
//	static EntityManagerFactory emf = null;
//	Logger log = Logger.getLogger("TestJPQL");
//
//	@BeforeClass
//	public static void init() throws Exception {
//		EJBContainer.createEJBContainer();
//		emf = Persistence.createEntityManagerFactory("TauLabsEntidadesEJB");
//	}
//
//	@Before
//	public void setup() {
//		try {
//			em = emf.createEntityManager();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	@SuppressWarnings("unchecked")
////	@Test
//	public void testActualizarObjeto() {
//		System.out.println("Iniciando test Persona Entity con JPA");
//		assertTrue(em != null);
//		EntityTransaction tx = em.getTransaction();
//		tx.begin(); 
//		// No se debe especificar el ID, ya que se genera en automático 
////		Entidad persona1 = new Entidad("NOMBRE","NOMBRE");
////		 log.debug("Objeto a persistir:" + persona1);
////		 em.persist(persona1); assertTrue(persona1.getId()!= null); tx.commit(); 
////		 log.debug("Objeto persistido:" +persona1); 
//		 System.out.println("Fin test Persona Entitycon JPA");
//		
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		if (em != null) {
//			em.close();
//		}
//	}
//
//}
