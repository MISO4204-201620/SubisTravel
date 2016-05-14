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

	SessionClientDTO validarLogin(SessionClientDTO sessionClientDTO) throws ServiceEJBException;

	SessionClientDTO accederConSocialId(String socialId) throws ServiceEJBException;

	SessionClientDTO altaConSocialId(SessionClientDTO sessionClientDTO) throws ServiceEJBException;

	List<UsuarioDTO> obtenerUsuariosPorTipo(String tipo) throws PersistenceException;
}
