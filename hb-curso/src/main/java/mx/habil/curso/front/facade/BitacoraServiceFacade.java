package mx.habil.curso.front.facade;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.business.appservice.BitacoraAppService;
import mx.habil.curso.front.vo.UsuarioVo;
import mx.habil.curso.model.dto.UsuarioDto;

import org.springframework.beans.factory.annotation.Autowired;

@CommonsLog
public class BitacoraServiceFacade {
	@Autowired BitacoraAppService service;
	
	public void guardarUsuario(UsuarioVo usuarioFront){
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
}
