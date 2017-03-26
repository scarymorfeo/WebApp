package com.santander.app.dao;



import java.util.List;

import com.santander.app.bean.UsuarioBean;
import com.santander.commons.exceptions.DAOException;

public interface UsuarioDao {
	
	public UsuarioBean getUsuario(String mail) throws DAOException;
	
}
