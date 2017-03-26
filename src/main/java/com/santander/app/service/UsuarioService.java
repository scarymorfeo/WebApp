/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santander.app.service;




import java.util.List;

import com.santander.app.bean.UsuarioBean;
import com.santander.commons.exceptions.ServiceException;



/**
 *
 * @author Z615563
 */
public interface UsuarioService {
    
    
	public UsuarioBean getUsuario(String email) throws ServiceException;


}
