package mx.habil.curso.model.dao;

import java.util.Date;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dto.EventoDto;

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
public class EventoDaoTestCase {
	@Autowired EventoDao eventoDao;
	
	@Before public void init(){
		log.debug("inicio");
		log.debug("fin");
	}
	
	@Test public void testGuardarEvento(){
		log.debug("inicio");
		Date now = new Date();
		EventoDto eventoDto = new EventoDto();
		eventoDto.setEvento("ALTA");
		eventoDto.setClase("HABIL");
		eventoDto.setSubClase("EMPELADO");
		eventoDto.setComentarios("Prueba unitaria de guardado de bitacora.");
		eventoDto.setFechaEvento(now);
		eventoDto.setFechaRegistro(now);
		
		eventoDao.save(eventoDto);
		log.debug("fin");
	}
	
	@Test public void testEliminarEvento(){
		log.debug("inicio");
		EventoDto eventoDto = new EventoDto();
		eventoDto.setId("e482ddaf-5f01-4b63-aae0-19e1ac7c1215");
		
		eventoDao.delete(eventoDto);
		
		log.debug("fin");
	}
}
