package mx.habil.curso.front.controller;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.front.facade.BitacoraServiceFacade;
import mx.habil.curso.front.vo.UsuarioGuardarVo;
import mx.habil.curso.front.vo.UsuarioRecuperaVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CommonsLog
@RestController
@RequestMapping(value="/protected/service/usuario")
//@Secured("IS_AUTHENTICATED_FULLY")
public class UsuarioServiceController {
	@Autowired private BitacoraServiceFacade facade;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> guardar(@RequestBody UsuarioGuardarVo usuario){
		log.debug("inicio");
		ResponseEntity<?> result = null;
		try{
			facade.guardarUsuario(usuario);
			result = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.debug("fin");
		return result;
	}
	
	@RequestMapping(value="/${cveUsuario}", method = RequestMethod.GET)
	public ResponseEntity<?> recuperaUsuarioPorClave(@PathVariable String cveUsuario){
		log.debug("inicio");
		ResponseEntity<?> result = null;
		try{
			UsuarioRecuperaVo usuario = facade.recuperaUsuarioPorClave(cveUsuario);
			result = new ResponseEntity<UsuarioRecuperaVo>(usuario, HttpStatus.OK);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			result = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.debug("fin");
		return result;
	}
}
