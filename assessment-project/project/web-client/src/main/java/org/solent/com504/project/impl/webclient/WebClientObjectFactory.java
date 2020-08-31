/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.webclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.factoryandfacade.impl.service.rest.client.ClientObjectFactoryImpl;
import org.solent.com504.project.impl.webclient.WebClientObjectFactory;
import org.solent.com504.meter.model.rest.MeterServiceFacadeRest;
import org.solent.com504.meter.model.rest.MeterServiceRestObjectFactory;

/**
 *
 * @author gallenc
 */
public class WebClientObjectFactory {
    // SETS UP LOGGING
    final static Logger LOG = LogManager.getLogger(WebClientObjectFactory.class);

    private static MeterServiceFacadeRest serviceFacadeRest = null;

    public static MeterServiceFacadeRest getServiceFacade() {
        if (serviceFacadeRest == null) {
            synchronized (WebClientObjectFactory.class) {
                if (serviceFacadeRest == null) {
                    LOG.debug("client web application starting");
                    MeterServiceRestObjectFactory clientObjectFactory = new ClientObjectFactoryImpl();
                    serviceFacadeRest = clientObjectFactory.getServiceFacadeRest();
                }
            }
        }
        return serviceFacadeRest;
    }

}
