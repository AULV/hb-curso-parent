package mx.habil.curso.model.dao;

import java.util.Date;

import mx.habil.curso.model.dto.EventoDto;
import mx.habil.support.HabilDao;
import mx.habil.support.HabilDaoException;
import mx.habil.support.HabilSearchResultDto;

public interface EventoDao extends HabilDao<EventoDto, String>{
	public HabilSearchResultDto<EventoDto> busqueda(final String evento, final String clase, final String subClase, final String comentarios, final Date fechaEventoInicio, final Date fechaEventoFin,final Integer page, final Integer rows, final String sidx, final String sord) throws HabilDaoException;
}
