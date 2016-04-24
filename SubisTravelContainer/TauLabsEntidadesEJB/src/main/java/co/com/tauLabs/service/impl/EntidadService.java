package co.com.tauLabs.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.tauLabs.dao.IEntidadDao;
import co.com.tauLabs.dao.IGenericDao;
import co.com.tauLabs.dao.IUsuarioDao;
import co.com.tauLabs.dto.FilterDTO;
import co.com.tauLabs.dto.PaginateDTO;
import co.com.tauLabs.dto.UsuarioDTO;
import co.com.tauLabs.enums.EntidadEstadoEnum;
import co.com.tauLabs.exception.PersistenceEJBException;
import co.com.tauLabs.exception.ServiceEJBException;
import co.com.tauLabs.exception.ValidationException;
import co.com.tauLabs.model.Entidad;
import co.com.tauLabs.model.Usuario;
import co.com.tauLabs.service.IEntidadService;

@Stateless
@Named
public class EntidadService extends GenericService<Entidad, Long> implements IEntidadService {

	private static final long serialVersionUID = 1L;

	@Inject private IEntidadDao entidadDao;
	@Inject private IUsuarioDao usuarioDao;

	public EntidadService() {
		
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostConstruct
	public void entidadService(){
		super.genericDao = (IGenericDao) entidadDao;
	}
	
	@Override
	public Entidad agregarProveedor(UsuarioDTO usuarioDTO) throws ServiceEJBException {
		try{
			Usuario usuario = new Usuario();
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setPassword(usuarioDTO.getPassword());
			usuario.setEstado("ACTIVO");
			
			Entidad entidad = new Entidad();
			entidad.setNombre(usuarioDTO.getNombre());
			entidad.setDireccion(usuarioDTO.getDireccion());
			entidad.setIdentificacion(usuarioDTO.getIdentificacion());
			entidad.setIdTipo(4L);
			entidad.setImagenPrincipal(usuarioDTO.getImagenPrincipal());
			entidad.setEstado("ACTIVO");
			entidadDao.guardar(entidad);
			
			usuario.setIdEntidad(entidad.getId());
			usuarioDao.guardar(usuario);
			return entidad;
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error al agregar el proveedor de servicios, causa: "+e.getMessage());
		}
	}
	
	@Override
	public List<Usuario> clientesPorEntidad(Long idEntidad) throws ServiceEJBException {
		logger.debug("CS iniciando metodo clientesPorEntidad()");
		try{
			if(idEntidad==null) throw new Exception("El identificador de la entidad es nulo");
			return usuarioDao.clientesPorEntidad(idEntidad);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando los clientes de una entidad, causa: "+e.getMessage());
		}
	}
	
	@Override
	public List<Entidad> obtenerEntidadesPorTipo(Long idTipo) throws ServiceEJBException {
		logger.debug("CS iniciando metodo obtenerEntidadesPorTipo()");
		try{
			if(idTipo==null) throw new Exception("Los filtros ingresados son nulos");
			return entidadDao.obtenerEntidadesPorTipo(idTipo);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando entidades por tipo, causa: "+e.getMessage());
		}
	}

	@Override
	public PaginateDTO filtrados(FilterDTO filtros) throws ServiceEJBException {
		logger.debug("CS iniciando metodo filtrados()");
		try{
			if(filtros==null)throw new ValidationException("El filtro ingresado es nulo");
			return entidadDao.filtrados(filtros);
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando entidades por filtros, causa: "+e.getMessage());
		}
		
	}
	
	@Override
	public List<Entidad> solicitudesBaja() throws ServiceEJBException {
		logger.debug("CS iniciando metodo solicitudesBaja()");
		try{
			
			List<Entidad> entidades = entidadDao.obtenerEntidadesPorEstado(EntidadEstadoEnum.SOLICITUDBAJA.getValue());
			for (Entidad entidad : entidades) {
				entidad.setUsuarios(null);
			}
			return entidades;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando entidades por solicitudesBaja, causa: "+e.getMessage());
		}
		
	}
	
	@Override
	public Entidad solicitarBaja(Long id) throws ServiceEJBException {
		logger.debug("CS iniciando metodo solicitarBaja()");
		try{
			if(id==null)throw new ValidationException("El id ingresado es nulo");
			Entidad entidad = entidadDao.obtenerPorId(id);
			entidad.setEstado(EntidadEstadoEnum.SOLICITUDBAJA.getValue());
			entidadDao.modificar(entidad);
			return entidad;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error solicitando Baja, causa: "+e.getMessage());
		}
		
	}
	
	
	@Override
	public Entidad darBaja(Long id) throws ServiceEJBException {
		logger.debug("CS iniciando metodo filtrados()");
		try{
			if(id==null)throw new ValidationException("El id ingresado es nulo");
			Entidad entidad = entidadDao.obtenerPorId(id);
			entidad.setEstado(EntidadEstadoEnum.BAJA.getValue());
			entidadDao.modificar(entidad);
			return entidad;
		}catch(PersistenceEJBException e){
			throw new ServiceEJBException(e.getMessage());
		}catch(Exception e){
			throw new ServiceEJBException("CS Ha ocurrido un error consultando entidades por filtros, causa: "+e.getMessage());
		}
		
	}
}
