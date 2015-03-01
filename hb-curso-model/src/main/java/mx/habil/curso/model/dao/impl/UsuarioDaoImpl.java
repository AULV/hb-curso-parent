package mx.habil.curso.model.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dao.UsuarioDao;
import mx.habil.curso.model.dto.UsuarioDto;
import mx.habil.support.hbm.HabilHbmDaoSupport;

@CommonsLog
@Repository("UsuarioDao")
@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
public class UsuarioDaoImpl extends HabilHbmDaoSupport<UsuarioDto, String> implements UsuarioDao{
		
		public UsuarioDaoImpl(){
			super(UsuarioDto.class);
			log.debug("inicio");
			log.debug("fin");
		}
		
		
}
