package org.solent.com504.project.impl.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.meter.impl.dao.jpa.MeterDAOFactoryJpaImpl;
import org.solent.com504.meter.model.dao.ParkingMeterDao;
import org.solent.com504.meter.model.dao.WeeklyChargingSchemeDao;
import org.solent.com504.meter.model.dao.MeterDAOFactory;
import org.solent.com504.meter.model.service.MeterServiceFacade;
import org.solent.com504.meter.model.service.MeterServiceObjectFactory;

// This is a hard coded implementation of the factory using the jaxb DAO 
// and could be replaced by Spring
public class ServiceObjectFactoryJpaImpl implements MeterServiceObjectFactory {

    final static Logger LOG = LogManager.getLogger(ServiceObjectFactoryJpaImpl.class);

    private ServiceFacadeImpl serviceFacade = null;
    ParkingMeterDao parkingMeterDao = null;
    WeeklyChargingSchemeDao weeklyCharkingSchemeDao = null;
    private MeterDAOFactory meterDaoFactory = null;

    /**
     * Initialises farmFacade objectFactory
     */
    public ServiceObjectFactoryJpaImpl() {

        meterDaoFactory = new MeterDAOFactoryJpaImpl();
        parkingMeterDao = meterDaoFactory.getParkingMeterDAO();
        weeklyCharkingSchemeDao = meterDaoFactory.getWeeklyChargingSchemeDAO();

        serviceFacade = new ServiceFacadeImpl();
        serviceFacade.setParkingMeterDao(parkingMeterDao);
        serviceFacade.setWeeklyChargingSchemeDao(weeklyCharkingSchemeDao);
    }

    @Override
    public MeterServiceFacade getServiceFacade() {
        return serviceFacade;
    }

    @Override
    public void shutDown() {
        LOG.debug("SERVICE OBJECT FACTORY SHUTTING DOWN ");
        if (meterDaoFactory != null) {
            meterDaoFactory.shutDown();
        }
    }

}
