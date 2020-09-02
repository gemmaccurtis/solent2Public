/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.meter.model.dto;

import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
/**
 *
 * @author GemmaC
 */
public class ParkingTicket {
    private Long id;
    private Long issueDate;
    private Long duration;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date date) {
        this.issueDate = date.getTime();
    }
    
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Date date) {
        this.duration = date.getTime();
    }

    @Override
    public String toString() {
        return "ParkingTicket{" + "id=" + id + ", issueDate=" + issueDate + ", duration=" + duration + '}';
    }
}
