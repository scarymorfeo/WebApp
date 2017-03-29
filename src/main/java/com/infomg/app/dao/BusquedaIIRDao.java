package com.infomg.app.dao;



import java.util.List;

import com.infomg.app.bean.UsuarioApBean;
import com.infomg.commons.exceptions.DAOException;

public interface BusquedaIIRDao {
	
	public List<UsuarioApBean> getListaClientes(String param) throws DAOException;
	
}
