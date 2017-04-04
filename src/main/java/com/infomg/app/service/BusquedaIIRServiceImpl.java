package com.infomg.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infomg.app.bean.UsuarioApBean;
import com.infomg.app.dao.BusquedaIIRDao;
import com.infomg.commons.exceptions.DAOException;
import com.infomg.commons.exceptions.ServiceException;

@Service
public class BusquedaIIRServiceImpl implements BusquedaIIRService {

	@Autowired
	BusquedaIIRDao busquedaIIRDao;
	
	@Override
	public List<UsuarioApBean> getClientesIIR(String param,String param2) throws ServiceException{
		
		List<UsuarioApBean> listaUsuarios =null;
		try {
			listaUsuarios = busquedaIIRDao.getListaClientes(param,param2);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//        UsuarioApBean usr = new UsuarioApBean();
//
//        usr.setPenumper("sss");
//        usr.setNombre("Nombre Usuario 1");
//        usr.setRfc("USR00001");
//
//        
//        listaUsuarios.add(usr);
		
		return listaUsuarios;
	}
	
}
