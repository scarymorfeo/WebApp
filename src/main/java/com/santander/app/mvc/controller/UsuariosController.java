package com.santander.app.mvc.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.santander.app.service.UsuarioService;


/**
 * Clase que controla todas las peticiones relacionadas alta de usuarios
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 03/08/2016
 */
@Controller
public class UsuariosController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(UsuariosController.class);  
	
	@Autowired
	UsuarioService usuarioService;
	
	
    @RequestMapping(value = "/usuarios.htm",method = RequestMethod.GET)
    public String mostrarUsuarios(){
    	LOG.debug("Controller para redirigir a la pantalla de usuarios");
        return "usuarios";
    }
    
    
	
}
