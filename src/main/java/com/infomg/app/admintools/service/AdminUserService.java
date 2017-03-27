package com.infomg.app.admintools.service;

import com.infomg.app.admintools.bean.AdminUserBean;
import com.infomg.commons.exceptions.ServiceException;

/**
 * Service for administrator user authentication
 *
 * @author OMartinez (1.0.0)
 * @version 1.0.0, 15/07/2016
 */
public interface AdminUserService {

    /**
     * Method for authenticate to the administrator user
     *
     * @param adminUser usuario
     * @return indicator of the autentication of the admin user
     * @throws ServiceException service exception
     */
    public boolean authenticate(AdminUserBean adminUser) throws ServiceException;
}
