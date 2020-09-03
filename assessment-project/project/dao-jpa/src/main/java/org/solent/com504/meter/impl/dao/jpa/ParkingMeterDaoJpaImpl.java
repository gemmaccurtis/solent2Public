package org.solent.com504.meter.impl.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.meter.model.dao.ParkingMeterDao;
import org.solent.com504.meter.model.dto.ParkingMeter;


public class ParkingMeterDaoJpaImpl implements ParkingMeterDao {

    final static Logger LOG = LogManager.getLogger(ParkingMeterDaoJpaImpl.class);

    private EntityManager entityManager;

    public ParkingMeterDaoJpaImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public ParkingMeter findById(Long id) {
        ParkingMeter parkingMeter = entityManager.find(ParkingMeter.class, id);
        return parkingMeter;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParkingMeter save(ParkingMeter parkingMeter) {
        entityManager.getTransaction().begin();
        entityManager.persist(parkingMeter);
        entityManager.getTransaction().commit();
        return parkingMeter;
    }

    @Override
    public List<ParkingMeter> findAll() {
        TypedQuery<ParkingMeter> q = entityManager.createQuery("SELECT p FROM ParkingMeter p", ParkingMeter.class);
        List<ParkingMeter> ParkingMeterList = q.getResultList();
        return ParkingMeterList;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("DELETE FROM ParkingMeter p WHERE p.id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
        entityManager.getTransaction().commit();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM ParkingMeter ").executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public ParkingMeter findBySerialNumber(String serialNumber) {
        TypedQuery<ParkingMeter> q = entityManager.createQuery("SELECT p FROM ParkingMeter p WHERE p.serialNumber=:serialNumber", ParkingMeter.class);
        q.setParameter("serialNumber", serialNumber);
        ParkingMeter parkingMeter = q.getSingleResult();
        return parkingMeter;    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
