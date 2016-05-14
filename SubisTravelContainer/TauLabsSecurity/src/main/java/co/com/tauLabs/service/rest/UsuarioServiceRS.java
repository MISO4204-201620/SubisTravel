package co.com.tauLabs.service.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.service.ILoginService;
import co.com.tauLabs.service.IUsuarioService;

@Path("/usuarios")
@RequestScoped
public class UsuarioServiceRS {

	final static Logger logger = Logger.getLogger(UsuarioServiceRS.class);

	@EJB
	private IUsuarioService usuarioService;
	@EJB
	private ILoginService loginService;

	public UsuarioServiceRS() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Entidad> listar() {
		logger.info("listar actualizado");
		try {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("loguear")
	public SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) {
		logger.debug("CR iniciando servicio validarLogin()");
		try {
			return loginService.validarLogin(sessionClientDTO);
		} catch (Exception e) {
			logger.error("CR Error validando login de usuario, causa: " + e.getMessage());
			return null;
		}
	}

	// @POST
	// @Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Path("loguear")
	// public SessionClientDTO validarLogin(LoginDTO loginDTO){
	// logger.debug("CR iniciando servicio validarLogin()");
	// try {
	// return usuarioService.validarLogin(loginDTO);
	// } catch (Exception e) {
	// logger.error("CR Error validando login de usuario, causa:
	// "+e.getMessage());
	// return null;
	// }
	// }

	// @POST
	// @Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Path("accederConSocialId")
	// public SessionClientDTO accederConSocialId(SocialLoginDTO
	// socialLoginDTO){
	// logger.debug("CR iniciando servicio accederConSocialId()");
	// try {
	// return usuarioService.accederConSocialId(socialLoginDTO);
	// } catch (Exception e) {
	// logger.error("CR Error validando login de usuario, causa:
	// "+e.getMessage());
	// return null;
	// }
	// }

}
