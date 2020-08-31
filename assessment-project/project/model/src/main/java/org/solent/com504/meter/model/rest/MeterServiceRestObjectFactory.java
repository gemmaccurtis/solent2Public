/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.meter.model.rest;

/**
 *
 * @author Elliott
 */
public interface MeterServiceRestObjectFactory {
    
    public MeterServiceFacadeRest getServiceFacadeRest();
    
    public void shutDown();
    
}
