package org.solent.com504.meter.model.rest;

import org.solent.com504.meter.model.dto.MeterReplyMessage;

public interface MeterServiceFacadeRest {

    public String getHeartbeat();
    
    /**
     * Sends REST get request to get parking meter with matching serial number
     *
     * @param serialNumber
     * @return ReplyMessage containing worker object
     *
     */
    public MeterReplyMessage getParkingMeterConfig();
}
