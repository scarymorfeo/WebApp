package com.infomg.app.appstatus.service;

import java.util.List;

import com.infomg.app.appstatus.bean.ApplicationStatusBean;

/**
 * Application status interface
 *
 * @author OMartinez
 * @version 1.0.0, 04/07/2016
 */
public interface ApplicationStatusService {
    /**
     * Method that must be implemented to return application status
     *
     * @return Lista de ApplicationStatusBean
     */
    public List<ApplicationStatusBean> getApplicationStatus();
}
