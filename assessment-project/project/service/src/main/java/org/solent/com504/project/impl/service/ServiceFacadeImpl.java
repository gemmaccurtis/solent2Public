package org.solent.com504.project.impl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.solent.com504.meter.model.dao.ParkingMeterDao;
import org.solent.com504.meter.model.dao.WeeklyChargingSchemeDao;
import org.solent.com504.meter.model.dto.DailyChargingScheme;
import org.solent.com504.meter.model.dto.ParkingMeter;
import org.solent.com504.meter.model.dto.WeeklyChargingScheme;
import org.solent.com504.meter.model.service.MeterServiceFacade;


public class ServiceFacadeImpl implements MeterServiceFacade {

    private ParkingMeterDao parkingMeterDao = null;

    private WeeklyChargingSchemeDao weeklyChargingSchemeDao = null;
    
       // used to concurently count heartbeat requests
    private static AtomicInteger heartbeatRequests = new AtomicInteger();

    // setters for DAOs
    public void setParkingMeterDao(ParkingMeterDao parkingMeterDao) {
        this.parkingMeterDao = parkingMeterDao;
    }

    public void setWeeklyChargingSchemeDao(WeeklyChargingSchemeDao weeklyChargingSchemeDao) {
        this.weeklyChargingSchemeDao = weeklyChargingSchemeDao;
    }

    // Service facade methods

    @Override
    public String getHeartbeat() {
        return "heartbeat number "+heartbeatRequests.getAndIncrement()+ " "+ new Date().toString();
    }

    @Override
    public ParkingMeter getParkingMeter(String serialNumber) {
        return parkingMeterDao.findBySerialNumber(serialNumber);
    }

    @Override
    public List<ParkingMeter> getParkingMeters() {
        return parkingMeterDao.findAll();
    }

    @Override
    public List<WeeklyChargingScheme> getWeeklyChargingSchemes() {
        return weeklyChargingSchemeDao.findAll();
    }

    @Override
    public WeeklyChargingScheme addChargingScheme(WeeklyChargingScheme chargingScheme) {
        return weeklyChargingSchemeDao.save(chargingScheme);
    }
    
    @Override
    public ParkingMeter addParkingMeter(ParkingMeter parkingMeter) {
        return parkingMeterDao.save(parkingMeter);
    }
    
}
