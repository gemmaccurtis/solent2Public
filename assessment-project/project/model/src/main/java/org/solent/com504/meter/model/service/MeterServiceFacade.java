package org.solent.com504.meter.model.service;
import java.util.List;
import org.solent.com504.meter.model.dto.WeeklyChargingScheme;
import org.solent.com504.meter.model.dto.ParkingMeter;

public interface MeterServiceFacade {

    public String getHeartbeat();
    
    public ParkingMeter getParkingMeter(String serialNumber);

    public List<ParkingMeter> getParkingMeters();
    
    public List<WeeklyChargingScheme> getWeeklyChargingSchemes();
    
    public WeeklyChargingScheme addChargingScheme(WeeklyChargingScheme chargingScheme);

    public ParkingMeter addParkingMeter(ParkingMeter parkingMeter);
    
    
    
}
