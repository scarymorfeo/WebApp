package com.infomg.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infomg.app.bean.UsuarioApBean;
import com.infomg.commons.exceptions.ServiceException;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public List<UsuarioApBean> getClientesIIR() throws ServiceException{
		
		List<UsuarioApBean> listaUsuarios = new ArrayList<UsuarioApBean>();
        UsuarioApBean usr = new UsuarioApBean();
        UsuarioApBean usr2 = new UsuarioApBean();
        UsuarioApBean usr3 = new UsuarioApBean();
        
        usr.setNombre("Nombre Usuario 1");
        usr.setUsuario("USR00001");

        usr2.setNombre("Nombre Usuario 2");
        usr2.setUsuario("USR00002");
        
        usr3.setNombre("Nombre Usuario 3");
        usr3.setUsuario("USR00003");
        
        listaUsuarios.add(usr);
        listaUsuarios.add(usr2);
        listaUsuarios.add(usr3);
		
		
		return listaUsuarios;
	}
	
}
