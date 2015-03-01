package mx.habil.curso.business.appservice;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dto.UsuarioDto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@CommonsLog
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
			"classpath:mx/habil/curso/commons/xml/commons.application.context.xml",
			"classpath:mx/habil/curso/model/xml/model.application.context.xml"
		})
public class BitacoraAppServiceTestCase {
	@Autowired private BitacoraAppService service; 
	
	@Before public void init(){
		log.debug("inicio");
		
		log.debug("fin");
	}
	
	@Test public void guardarUsuario(){
		log.debug("inicio");
		UsuarioDto usuario = null;
		{
			usuario = new UsuarioDto();
			usuario.setCveUsuario("rchargoy");
			usuario.setNombre("Rogert");
			usuario.setApPaterno("Chargoy");
			usuario.setApMaterno("Martinez");
			usuario.setActivo(Boolean.TRUE);
		}
		
		service.guardarUsuario(usuario);
		log.debug("fin");
	}
}
