package co.com.tauLabs.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import co.com.tauLabs.dto.LoginDTO;
import co.com.tauLabs.dto.SessionClientDTO;
import co.com.tauLabs.dto.SocialLoginDTO;
import co.com.tauLabs.dto.UsuarioDTO;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.model.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario, Long> {
	
	List<Usuario> clientesPorEntidad(Long idEntidad) throws ServiceEJBException;

	SessionClientDTO validarLogin(LoginDTO loginDTO) throws ServiceEJBException;

	SessionClientDTO accederConSocialId(String socialId) throws ServiceEJBException;

	SessionClientDTO altaConSocialId(SocialLoginDTO socialLoginDTO) throws ServiceEJBException;
	
	List<UsuarioDTO> obtenerUsuariosPorTipo(String tipo) throws PersistenceException;
}
