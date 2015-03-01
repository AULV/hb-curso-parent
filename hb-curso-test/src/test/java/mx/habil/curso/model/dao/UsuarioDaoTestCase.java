package mx.habil.curso.model.dao;

import java.util.Date;

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
public class UsuarioDaoTestCase {
	@Autowired UsuarioDao usuarioDao;
	
	@Before public void init(){
		log.debug("inicio");
		log.debug("fin");
	}
	
	@Test public void testGuardar(){
		log.debug("inicio");
		UsuarioDto usuario = null;
		{
			usuario = new UsuarioDto();
			usuario.setCveUsuario("dchavez");
			usuario.setNombre("Dorian");
			usuario.setApPaterno("Chavez");
			usuario.setApMaterno("Juarez");
			usuario.setFechaRegistro(new Date());
			usuario.setActivo(Boolean.TRUE);
		}
		usuarioDao.save(usuario);
		log.debug("fin");
	}
	
	
}
