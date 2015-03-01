package mx.habil.curso.business.appservice;

import java.util.Date;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dao.UsuarioDao;
import mx.habil.curso.model.dto.UsuarioDto;
import mx.habil.support.HabilAppServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@CommonsLog
@Service("BitacoraAppService")
@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
public class BitacoraAppService {
	private @Autowired UsuarioDao usuarioDao;
	
	public void guardarUsuario(UsuarioDto usuario){
		log.debug("inicio");
		{//Validaciones
			if(usuario==null){
				throw new HabilAppServiceException("La información del usuario a guardar no debe ser nula.");
			}
			
			if(usuario.getCveUsuario()==null || usuario.getCveUsuario().trim().isEmpty()){
				throw new HabilAppServiceException("La clave del usuario a guardar no debe ser nula.");
			}
			
			if(usuario.getNombre()==null || usuario.getNombre().trim().isEmpty()){
				throw new HabilAppServiceException("El nombre del usuario a guardar no debe ser nulo.");
			}
		}
		
		if(usuario.getActivo()==null){
			usuario.setActivo(Boolean.FALSE);
		}
		
		usuario.setFechaRegistro(new Date());
		
		usuarioDao.save(usuario);
		log.debug("fin");
	}
	
	public UsuarioDto recuperaUsuarioPorClave(final String cveUsuario){
		log.debug("inicio");
		UsuarioDto result = null;
		{//Validaciones
			if(cveUsuario==null || cveUsuario.trim().isEmpty()){
				throw new HabilAppServiceException("La clave del usuario a buscar no debe ser nula.");
			}
		}
		
		result = usuarioDao.recuperaPorCveUsuario(cveUsuario);
		
		log.debug("fin");
		return result;
		
	}
	
}
