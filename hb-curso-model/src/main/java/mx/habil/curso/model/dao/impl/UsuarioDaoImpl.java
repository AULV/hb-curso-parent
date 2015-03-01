package mx.habil.curso.model.dao.impl;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dao.UsuarioDao;
import mx.habil.curso.model.dto.UsuarioDto;
import mx.habil.support.HabilDaoException;
import mx.habil.support.hbm.HabilHbmDaoSupport;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@CommonsLog
@Repository("UsuarioDao")
@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
public class UsuarioDaoImpl extends HabilHbmDaoSupport<UsuarioDto, String> implements UsuarioDao{
		
	public UsuarioDaoImpl(){
		super(UsuarioDto.class);
		log.debug("inicio");
		log.debug("fin");
	}
	
	public UsuarioDto recuperaPorCveUsuario(final String cveUsuario) throws HabilDaoException{
		log.debug("inicio");
		UsuarioDto result = null;
		
		{//Validaciones
			if(cveUsuario==null || cveUsuario.trim().isEmpty()){
				throw new HabilDaoException("La clave del usuario no debe ser nula.");
			}
		}
		
		result = getHibernateTemplate().execute(new HibernateCallback<UsuarioDto>() {
			public UsuarioDto doInHibernate(Session session) throws HibernateException {
				log.debug("inicio");
				UsuarioDto result = null;
				Criteria crit= session.createCriteria(UsuarioDto.class);
				crit.add(Restrictions.eq("cveUsuario", cveUsuario));
				result = (UsuarioDto)crit.uniqueResult();
				log.debug("fin");
				return result;
			}
		});
		log.debug("fin");
		return result;
	}
}
