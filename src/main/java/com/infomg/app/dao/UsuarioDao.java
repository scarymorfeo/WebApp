package com.infomg.app.dao;



import java.util.List;

import com.infomg.app.bean.UsuarioBean;
import com.infomg.commons.exceptions.DAOException;

public interface UsuarioDao {
	
	public UsuarioBean getUsuario(String mail) throws DAOException;
	
}
