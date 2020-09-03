/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.meter.impl.dao.jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.meter.model.dao.ParkingMeterDao;
import org.solent.com504.meter.impl.dao.jpa.MeterDAOFactoryJpaImpl;
import org.solent.com504.meter.model.dao.MeterDAOFactory;
import org.solent.com504.meter.model.dto.Location;
import org.solent.com504.meter.model.dto.ParkingMeter;

/**
 *
 * @author cgallen
 */
public class ParkingMeterDaoTest {

    final static Logger LOG = LogManager.getLogger(ParkingMeterDaoTest.class);

    private ParkingMeterDao parkingMeterDao = null;

    private MeterDAOFactory daoFactory = new MeterDAOFactoryJpaImpl();

    @Before
    public void before() {
        parkingMeterDao = daoFactory.getParkingMeterDAO();
        assertNotNull(parkingMeterDao);
    }

    @Test
    public void createParkingMeterDaoTest() {
        LOG.debug("start of createParkingMeterDaoTest");
        // this test simply runs the before method
        LOG.debug("end of createParkingMeterDaoTest");
    }

    @Test
    public void createParkingMeterTest() {
        LOG.debug("createParkingMeterTest");
        
        // delete all previous meters and check isEmpty
        parkingMeterDao.deleteAll();
        assertTrue(parkingMeterDao.findAll().isEmpty());

        // add 5 meters with random serial numbers
        List<String> parkingMeterSerialNumbers = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            parkingMeterSerialNumbers.add(UUID.randomUUID().toString());
        }

        // create parking meters
        for (String parkingMeterSerialNumber : parkingMeterSerialNumbers) {
            ParkingMeter parkingMeter = new ParkingMeter();

            Location location = new Location();
            location.setAddress("10 Downing Street SW1");
            location.setCarParkName("Prime Mininser Park");
            //51.503497, -0.127577
            location.setLatitude(51.503497);
            location.setLongitude(-0.127577);
            parkingMeter.setLocation(location);
            parkingMeter.setSerialNumber(parkingMeterSerialNumber);

            parkingMeterDao.save(parkingMeter);
        }
        
        // check 5 meters have been added
        List<ParkingMeter> foundMeters = parkingMeterDao.findAll();
        assertEquals(5, foundMeters.size());

        LOG.debug("end of createParkingMeterTest");
    }
    
    @Test
    public void findParkingMeterById() {
        LOG.debug("findParkingMeterById");
        
        // delete all previous meters and check isEmpty
        parkingMeterDao.deleteAll();
        assertTrue(parkingMeterDao.findAll().isEmpty());

        // add 5 meters with random serial numbers
        List<String> parkingMeterSerialNumbers = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            parkingMeterSerialNumbers.add(UUID.randomUUID().toString());
        }

        // create parking meters
        for (String parkingMeterSerialNumber : parkingMeterSerialNumbers) {
            ParkingMeter parkingMeter = new ParkingMeter();

            Location location = new Location();
            location.setAddress("10 Downing Street SW1");
            location.setCarParkName("Prime Mininser Park");
            //51.503497, -0.127577
            location.setLatitude(51.503497);
            location.setLongitude(-0.127577);
            parkingMeter.setLocation(location);
            parkingMeter.setSerialNumber(parkingMeterSerialNumber);

            parkingMeterDao.save(parkingMeter);
        }
        
        // check 5 meters have been added
        List<ParkingMeter> foundMeters = parkingMeterDao.findAll();
        assertEquals(5, foundMeters.size());
        
        //check if we get the right parking meter by id
        ParkingMeter testMeter = foundMeters.get(1);
        Long testMeterId = testMeter.getId();
        ParkingMeter byIdMeter = parkingMeterDao.findById(testMeterId);
        
        assertEquals(testMeter, byIdMeter);
        
        //check if we get the right parking meter by id but do a different one than before.
        ParkingMeter testMeter2 = foundMeters.get(2);
        Long testMeterId2 = testMeter2.getId();
        ParkingMeter byIdMeter2 = parkingMeterDao.findById(testMeterId2);
        
        assertEquals(testMeter2, byIdMeter2);
                      
        LOG.debug("end of findParkingMeterById");
    }
    
    @Test
    public void deleteParkingMeterByIdTest() {
        LOG.debug("end of deleteParkingMeterByIdTest");
        parkingMeterDao.deleteAll();
        assertTrue(parkingMeterDao.findAll().isEmpty());
        
        for (int i = 0; i < 2; i++) {
            ParkingMeter parkingMeter = new ParkingMeter();

            Location location = new Location();
            location.setAddress("10 Downing Street SW1");
            location.setCarParkName("Prime Mininser Park");
            //51.503497, -0.127577
            location.setLatitude(51.503497);
            location.setLongitude(-0.127577);
            parkingMeter.setLocation(location);
            parkingMeter.setSerialNumber(UUID.randomUUID().toString());

            parkingMeterDao.save(parkingMeter);
        }
        
        assertEquals(2, parkingMeterDao.findAll().size());
        
        Long idOfParkingMeter1 = parkingMeterDao.findAll().get(0).getId();
        Long idOfParkingMeter2 = parkingMeterDao.findAll().get(1).getId();
        
        parkingMeterDao.deleteById(idOfParkingMeter1);
        
        assertEquals(1, parkingMeterDao.findAll().size());
        assertEquals(idOfParkingMeter2, parkingMeterDao.findAll().get(0).getId());
        
        parkingMeterDao.deleteById(idOfParkingMeter2);
        
        assertEquals(0, parkingMeterDao.findAll().size());
        LOG.debug("end of deleteParkingMeterByIdTest");
    }
    
    @Test
    public void deleteAllParkingMetersTest() {
        LOG.debug("deleteAllParkingMetersTest");
        parkingMeterDao.deleteAll();
        assertTrue(parkingMeterDao.findAll().isEmpty());
        
        for (int i = 0; i < 2; i++) {
            ParkingMeter parkingMeter = new ParkingMeter();

            Location location = new Location();
            location.setAddress("10 Downing Street SW1");
            location.setCarParkName("Prime Mininser Park");
            //51.503497, -0.127577
            location.setLatitude(51.503497);
            location.setLongitude(-0.127577);
            parkingMeter.setLocation(location);
            parkingMeter.setSerialNumber(UUID.randomUUID().toString());

            parkingMeterDao.save(parkingMeter);
        }
        
        assertEquals(2, parkingMeterDao.findAll().size());
        
        parkingMeterDao.deleteAll();
        
        assertEquals(0, parkingMeterDao.findAll().size());
        LOG.debug("end of deleteAllParkingMetersTest");
    }
    
    @Test
    public void findBySerialNumberParkingMeterTest() {
        LOG.debug("findBySerialNumberParkingMeterTest");
        
        // delete all previous meters and check isEmpty
        parkingMeterDao.deleteAll();
        assertTrue(parkingMeterDao.findAll().isEmpty());

        // add 5 meters with random serial numbers
        List<String> parkingMeterSerialNumbers = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            parkingMeterSerialNumbers.add(UUID.randomUUID().toString());
        }

        // create parking meters
        for (String parkingMeterSerialNumber : parkingMeterSerialNumbers) {
            ParkingMeter parkingMeter = new ParkingMeter();

            Location location = new Location();
            location.setAddress("10 Downing Street SW1");
            location.setCarParkName("Prime Mininser Park");
            //51.503497, -0.127577
            location.setLatitude(51.503497);
            location.setLongitude(-0.127577);
            parkingMeter.setLocation(location);
            parkingMeter.setSerialNumber(parkingMeterSerialNumber);

            parkingMeterDao.save(parkingMeter);
        }
        
        // check 5 meters have been added
        List<ParkingMeter> foundMeters = parkingMeterDao.findAll();
        assertEquals(5, foundMeters.size());

        //find parkingmeter by serial number
        ParkingMeter foundMeter = parkingMeterDao.findBySerialNumber(parkingMeterSerialNumbers.get(0));
        
        //do meters found by serial number match
        assertEquals(foundMeters.get(0), foundMeter);
        
        LOG.debug("end of findBySerialNumberParkingMeterTest");
    }
}
