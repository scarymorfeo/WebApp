package com.infomg.app.service;

import java.util.List;

import com.infomg.app.bean.UsuarioApBean;
import com.infomg.commons.exceptions.ServiceException;

public interface BusquedaIIRService {

	public List<UsuarioApBean> getClientesIIR(String param,String param2) throws ServiceException;
	
}
