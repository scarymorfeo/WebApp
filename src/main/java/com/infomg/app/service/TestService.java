package com.infomg.app.service;

import java.util.List;

import com.infomg.app.bean.UsuarioApBean;
import com.infomg.commons.exceptions.ServiceException;

public interface TestService {

	public List<UsuarioApBean> getClientesIIR() throws ServiceException;
	
}
