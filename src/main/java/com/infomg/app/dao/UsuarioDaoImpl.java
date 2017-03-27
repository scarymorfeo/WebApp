/**
 * 
 */
package com.infomg.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.infomg.app.bean.PerfilBean;
import com.infomg.app.bean.UsuarioBean;
import com.infomg.commons.exceptions.DAOException;
import com.infomg.commons.exceptions.FormatException;

/**
 * @author Omartinez
 *
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static final Logger LOGGER = Logger.getLogger("defaultLogger");

	private static final String QUERY_USUARIO = "SELECT ...."
			+ " AND EMAIL = :email";
	
    
    
	//private NamedParameterJdbcTemplate jdbcTemplate;

	/*@Autowired
	@Qualifier("dataSourceSntndr")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}*/

	private static final class UsuarioMapper implements RowMapper<UsuarioBean> {

		public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UsuarioBean usuario = new UsuarioBean();
			usuario.setNombre(rs.getString(1));
			
			return usuario;
		}
	}



	/**
	 * Método para obtener un usuario
	 *
	 * @return
	 * @throws DAOException
	 */
	@Override
	public UsuarioBean getUsuario(String mail) throws DAOException {

		LOGGER.info("Obtener usuario: " + mail);

		UsuarioBean usuario = new UsuarioBean();
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		try {

			LOGGER.debug("Ejecutando query: " + QUERY_USUARIO);

			//lista = this.jdbcTemplate.query(QUERY_USUARIO, parametros, new UsuarioMapper());

			usuario.setCorreo("");
			usuario.setNombre("Usuario Demo");
			usuario.setContrasena("Password");
			usuario.setIdUsuario(1);

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.trace(FormatException.obtieneStackTrace(e));
			throw new DAOException("Error en DAO: " + e.getMessage());
		}
		LOGGER.debug("Fin DAO");
		return usuario;
	}
	

    

}
