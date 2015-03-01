package mx.habil.curso.model.dao;

import mx.habil.curso.model.dto.UsuarioDto;
import mx.habil.support.HabilDao;
import mx.habil.support.HabilDaoException;


public interface UsuarioDao extends HabilDao<UsuarioDto, String>{
	public UsuarioDto recuperaPorCveUsuario(final String cveUsuario) throws HabilDaoException;
}
