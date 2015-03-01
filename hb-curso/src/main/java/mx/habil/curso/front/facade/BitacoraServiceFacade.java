package mx.habil.curso.front.facade;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.business.appservice.BitacoraAppService;
import mx.habil.curso.front.vo.UsuarioGuardarVo;
import mx.habil.curso.front.vo.UsuarioRecuperaVo;
import mx.habil.curso.model.dto.UsuarioDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@CommonsLog
@Service
public class BitacoraServiceFacade {
	@Autowired BitacoraAppService service;
	
	public void guardarUsuario(UsuarioGuardarVo usuarioFront){
		log.debug("inicio");
		UsuarioDto usuarioModel = null;
		{
			usuarioModel = new UsuarioDto();
			usuarioModel.setCveUsuario(usuarioFront.getCveUsuario());
			usuarioModel.setNombre(usuarioFront.getNombre());
			usuarioModel.setApPaterno(usuarioFront.getApPaterno());
			usuarioModel.setApMaterno(usuarioFront.getApMaterno());
			usuarioModel.setActivo(usuarioFront.getActivo());
		}
		service.guardarUsuario(usuarioModel);
		log.debug("fin");
	}
	
	public UsuarioRecuperaVo recuperaUsuarioPorClave(final String cveUsuario){
		log.debug("inicio");
		UsuarioRecuperaVo result = null;
		UsuarioDto usuarioModel = service.recuperaUsuarioPorClave(cveUsuario);
		
		{//Transformación al front
			if(usuarioModel!=null){
				result = new UsuarioRecuperaVo();
				{
					result.setId(usuarioModel.getId());
					result.setCveUsuario(usuarioModel.getId());
					result.setNombre(usuarioModel.getNombre());
					result.setApPaterno(usuarioModel.getApPaterno());
					result.setApMaterno(usuarioModel.getApMaterno());
					result.setActivo(usuarioModel.getActivo());
				}
			}
		}
		log.debug("fin");
		return result;
	}
}
