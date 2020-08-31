/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.service.rest.client.test.manual;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.factoryandfacade.impl.service.rest.client.ClientObjectFactoryImpl;
//import org.solent.com504.meter.model.service.MeterServiceFacade;
//import org.solent.com504.meter.model.service.MeterServiceObjectFactory;
import org.solent.com504.meter.model.rest.MeterServiceFacadeRest;
import org.solent.com504.meter.model.rest.MeterServiceRestObjectFactory;
        
/**
 *
 * @author gallenc
 */
public class RestClientServiceFacadeTest {

    final static Logger LOG = LogManager.getLogger(RestClientServiceFacadeTest.class);

    MeterServiceRestObjectFactory serviceObjectFactory = null;
    MeterServiceFacadeRest serviceFacade = null;

    List<String> supportedAnimalTypes = null;

    @Before
    public void loadFactory() {
        serviceObjectFactory = new ClientObjectFactoryImpl();
        serviceFacade = serviceObjectFactory.getServiceFacadeRest();
        assertNotNull(serviceFacade);
    }

    @Test
    public void testGetHeartbeat() {
        LOG.debug("start of testGetHeartbeat()");

        String heartbeat = serviceFacade.getHeartbeat();
        assertNotNull(heartbeat);
        LOG.debug("heartbeat received :" + heartbeat);

        LOG.debug("end of testGetHeartbeat()");
    }

}
