/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.meter.model.dto.Location;
import org.solent.com504.project.impl.service.ServiceObjectFactoryJpaImpl;
import org.solent.com504.meter.model.service.MeterServiceFacade;
import org.solent.com504.meter.model.service.MeterServiceObjectFactory;
import org.solent.com504.meter.model.dto.ParkingMeter;
import org.solent.com504.meter.model.dto.WeeklyChargingScheme;

/**
 *
 * @author gallenc
 */
public class ServiceFacadeJpaTest {
    
    MeterServiceObjectFactory serviceObjectFactory = null;
    MeterServiceFacade serviceFacade = null;


    @Before
    public void loadFactory() {

        serviceObjectFactory = new ServiceObjectFactoryJpaImpl();
        
        serviceFacade = serviceObjectFactory.getServiceFacade();

    }

    @Test
    public void testFactory() {
        System.out.println("start ServiceFacadeTest testFactory");
        assertNotNull(serviceFacade);

        System.out.println("end ServiceFacadeTest testFactory");
    }

    @Test
    public void testGetHeartbeat() {
        System.out.println("start ServiceFacadeTest testGetHeartbeat()");
        assertNotNull(serviceFacade);
        
        String heartbeat = serviceFacade.getHeartbeat();
        System.out.println("recieved heartbeat: "+heartbeat);
        assertNotNull(heartbeat);
        
        System.out.println("end ServiceFacadeTest testGetHeartbeat()");
    }
    
    @Test
    public void testAddParkingMeter() {
        System.out.println("start ServiceFacadeTest testAddParkingMeter()");
        assertNotNull(serviceFacade);
        
        serviceFacade.deleteAllParkingMeters();
        assertTrue(serviceFacade.getParkingMeters().isEmpty());
        
        ParkingMeter parkingMeter = new ParkingMeter();
        serviceFacade.addParkingMeter(parkingMeter);
        
        List<ParkingMeter> foundMeters = serviceFacade.getParkingMeters();
        
        assertEquals(foundMeters.get(0), parkingMeter);
        
        System.out.println("end ServiceFacadeTest testAddParkingMeter()");
    }
    
    @Test
    public void testGetParkingMeterBySerielNumber() {
        System.out.println("start ServiceFacadeTest testGetParkingMeterBySerielNumber()");
        assertNotNull(serviceFacade);
        
        serviceFacade.deleteAllParkingMeters();
        assertTrue(serviceFacade.getParkingMeters().isEmpty());
        
        
        ParkingMeter parkingMeter = new ParkingMeter();
        String serialNumber = UUID.randomUUID().toString();
       
        parkingMeter.setSerialNumber(serialNumber);
        serviceFacade.addParkingMeter(parkingMeter);
        
        ParkingMeter foundMeter = serviceFacade.getParkingMeter(serialNumber);
        
        assertEquals(foundMeter, parkingMeter);
        
        System.out.println("end ServiceFacadeTest testGetParkingMeterBySerielNumber()");
    }
            
    @Test
    public void testGetAllParkingMeters() {
        System.out.println("start ServiceFacadeTest testGetAllParkingMeters()");
        assertNotNull(serviceFacade);
        
        serviceFacade.deleteAllParkingMeters();
        assertTrue(serviceFacade.getParkingMeters().isEmpty());
        
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
            serviceFacade.addParkingMeter(parkingMeter);
        }
        
        // check 5 meters have been added
        List<ParkingMeter> foundMeters = serviceFacade.getParkingMeters();
        assertEquals(5, foundMeters.size());
           
        serviceFacade.deleteAllParkingMeters();
        assertTrue(serviceFacade.getParkingMeters().isEmpty());
             
        System.out.println("end ServiceFacadeTest testGetAllParkingMeters()");
    }
    
    @Test
    public void testAddGetDeleteWeeklyChargingSchemes() {
        System.out.println("start ServiceFacadeTest testGetWeeklyChargingSchemes()");
        
        serviceFacade.deleteAllweeklyChargingScheme();
        assertTrue(serviceFacade.getWeeklyChargingSchemes().isEmpty());
        
        for (int i = 0; i < 5; i++) {
            WeeklyChargingScheme weeklyChargingScheme = new WeeklyChargingScheme();
            serviceFacade.addChargingScheme(weeklyChargingScheme);
        }
        
        List<WeeklyChargingScheme> foundSchemes = serviceFacade.getWeeklyChargingSchemes();
        assertEquals(5, foundSchemes.size());
        
        serviceFacade.deleteAllweeklyChargingScheme();
        assertTrue(serviceFacade.getWeeklyChargingSchemes().isEmpty());

        System.out.println("end ServiceFacadeTest testGetWeeklyChargingSchemes()");
    }
    

    // WHAT OTEHR TESTS DO YOU NEED FOR HE SERVICE?
    
}
