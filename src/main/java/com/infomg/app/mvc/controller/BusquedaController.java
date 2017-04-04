package com.infomg.app.mvc.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infomg.app.bean.RespuestaJsonBean;
import com.infomg.app.bean.UsuarioApBean;
import com.infomg.app.service.BusquedaIIRService;
import com.infomg.commons.exceptions.ServiceException;





/**
 * Clase que controla todas las peticiones relacionadas alta
 * 
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 19/01/2017
 */
@Controller
public class BusquedaController extends BaseMultiActionController {

	private static final Logger LOG = Logger.getLogger(BusquedaController.class);  
	
	@Autowired
	BusquedaIIRService busquedaIIRService;

	
	
    @RequestMapping(value = "/busqueda.htm",method = RequestMethod.GET)
    public String pantalla0(){
    	LOG.debug("Controller para redirigir a la pantalla");
        return "busqueda";
    }	
	
 
    /**
     * Metodo para obtener la lista de bitacora
     *
     * @param request
     * @param model
     * @return
     */
	
	@RequestMapping(value = "/consultarBusqueda.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RespuestaJsonBean consultarPerfiles(final HttpServletRequest request,
			final Map<String, Object> model) {
	

		
    	LOG.info("Controller para obtener, en formato JSON, Bitacora");
        RespuestaJsonBean respuesta = new RespuestaJsonBean();
        List<UsuarioApBean> listaUsuarios = new ArrayList<UsuarioApBean>();

		JSONObject jsonObj = requestParamsToJSON(request);
		
		String param = null;
		String param2 = null;
		
		try{
		    param = jsonObj.getString("param");
		    param2 = jsonObj.getString("param2");
		}catch (JSONException ex){
			param = null;
			
		}        
        
        if(param == null){
        	listaUsuarios = new ArrayList<UsuarioApBean>();
            respuesta.setLista(listaUsuarios);
            respuesta.setEstatus("ok");
        }else{
        	
            try {
        	
            
        	listaUsuarios = busquedaIIRService.getClientesIIR(param,param2);
        	
             
            respuesta.setLista(listaUsuarios);
            respuesta.setEstatus("ok");

        } catch (ServiceException se) {
        	LOG.error("Error al obtener Bitacora: " + se.getMessage() + " " + se.toString());
            respuesta.setEstatus("error");
            respuesta.setMensaje(se.getMessage());
        }       	
        	
        }
		


        return respuesta;

    }	    
    
}
