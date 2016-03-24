package co.com.tauLabs.dao;

import co.com.tauLabs.dto.LoginDTO;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario, Long> {

	SessionClientDTO validarLogin(LoginDTO loginDTO) throws ServiceEJBException;

	SessionClientDTO accederConSocialId(String socialId) throws ServiceEJBException;
}
