/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomg.app.service;




import java.util.List;

import com.infomg.app.bean.UsuarioBean;
import com.infomg.commons.exceptions.ServiceException;



/**
 *
 * @author Z615563
 */
public interface UsuarioService {
    
    
	public UsuarioBean getUsuario(String email) throws ServiceException;


}
