package mx.habil.curso.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import lombok.extern.apachecommons.CommonsLog;
import mx.habil.curso.model.dao.EventoDao;
import mx.habil.curso.model.dto.EventoDto;
import mx.habil.support.HabilDaoException;
import mx.habil.support.HabilSearchResultDto;
import mx.habil.support.hbm.HabilHbmDaoSupport;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@CommonsLog
@Repository("EventoDao")
@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
public class EventoDaoImpl extends HabilHbmDaoSupport<EventoDto, String> implements EventoDao{
	
	public EventoDaoImpl(){
		super(EventoDto.class);
	}


	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public HabilSearchResultDto<EventoDto> busqueda(
													final String evento,
													final String clase,
													final String subClase,
													final String comentarios,
													final Date fechaEventoInicio,
													final Date fechaEventoFin,
													final Integer page, 
													final Integer rows,
													final String sidx, 
													final String sord
												   ) throws HabilDaoException {
		log.debug("inicio");
		HabilSearchResultDto<EventoDto> result = null;
		try{
			result = getHibernateTemplate().execute(new HibernateCallback<HabilSearchResultDto<EventoDto>>() {
				@SuppressWarnings("unchecked")
				public HabilSearchResultDto<EventoDto> doInHibernate(Session session) throws HibernateException {
					HabilSearchResultDto<EventoDto> auxResult = null;
					Criteria crit= session.createCriteria(EventoDto.class);
					{
						{//Aquí generamos el where
							if(evento!=null && !evento.isEmpty()){
								log.debug("evento:"+evento);
								crit.add(Restrictions.eq("evento", evento));
							}
							if(clase!=null && !clase.isEmpty()){
								log.debug("clase:"+clase);
								crit.add(Restrictions.ilike("clase", clase, MatchMode.ANYWHERE));
							}
							if(subClase!=null && !subClase.isEmpty()){
								log.debug("subClase:"+subClase);
								crit.add(Restrictions.ilike("subClase", subClase, MatchMode.ANYWHERE));
							}
							if(comentarios!=null && !comentarios.isEmpty()){
								log.debug("comentarios:"+comentarios);
								crit.add(Restrictions.ilike("comentarios", comentarios, MatchMode.ANYWHERE));
							}
							if(fechaEventoInicio!=null && fechaEventoFin!=null && fechaEventoInicio.before(fechaEventoFin)){
								log.debug("fechaEvento between "+fechaEventoInicio+" and "+fechaEventoFin);
								crit.add(Restrictions.between("fechaEvento", fechaEventoInicio, fechaEventoFin));
							}
							
						}
					}
					{//Aquí ordenamos el resultado de la búsqueda
						if(sidx!=null && !sidx.isEmpty()){
							if("asc".equals(sord.toLowerCase())){
								crit.addOrder(Order.asc(sidx));
							}else{
								crit.addOrder(Order.desc(sidx));
							}
						}
					}
					{//Aquí configuramos para obtener el número de registros que arrojará la consulta para paginar
						crit.setProjection(Projections.rowCount());
					}
					Long count = (Long)crit.uniqueResult();
					log.debug("count:"+count);
					
					auxResult = new HabilSearchResultDto<EventoDto>();
					auxResult.setCount(count);
					if(count>0){
						{//Quitamos configuración para obtener los registros y no el numero de registros
							crit.setProjection(null);
						}
						{//Configuración del páginado
							if(rows != null && rows > 0){
								crit.setMaxResults(rows);
								if(page != null && page > 0){
									crit.setFirstResult((page-1)*rows);
								}
							}
						}
						
						auxResult.setRows(crit.list());
					}else{
						auxResult.setRows(new ArrayList<EventoDto>(0));
					}
					return auxResult;
				}
				
			});
		}catch(Exception ex){
			throw new HabilDaoException(ex.getMessage(),ex);
		}
		log.debug("fin");
		return result;
	}
}
