/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.service.rest.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.meter.model.rest.MeterServiceFacadeRest;
import org.solent.com504.meter.model.rest.MeterServiceRestObjectFactory;

/**
 *
 * @author gallenc
 *//**
 *
 * @author gallenc
 *//**
 *
 * @author gallenc
 */
public class ClientObjectFactoryImpl implements MeterServiceRestObjectFactory {

    final static Logger LOG = LogManager.getLogger(ClientObjectFactoryImpl.class);
    
    private MeterServiceFacadeRest serviceFacade = null;
    private String baseUrl = "http://localhost:8084/projectfacadeweb/rest/appointmentService";
    
    @Override
    public MeterServiceFacadeRest getServiceFacadeRest() {
        
        if (serviceFacade == null) {
            LOG.debug("creating new ServiceRestClientImpl for baseUrl=" + baseUrl);
            synchronized (this) {
                if (serviceFacade == null) {
                    serviceFacade = new ServiceRestClientImpl(baseUrl);
                }
            }
        }
        
        return serviceFacade;
    }

    @Override
    public void shutDown() {
        // do nothing
    }
    
}
