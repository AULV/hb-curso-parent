package mx.habil.curso.business.appservice;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dto.UsuarioDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@CommonsLog
@Service("BitacoraAppService")
@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
public class BitacoraAppService {
	
	public void guardarUsuario(UsuarioDto usuario){
		log.debug("inicio");
		{//Validaciones
			if(usuario==null){
				
			}
		}
		log.debug("fin");
	}
}
