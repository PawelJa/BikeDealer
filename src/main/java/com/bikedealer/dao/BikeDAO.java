package com.bikedealer.dao;


import com.bikedealer.entity.Bike;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class BikeDAO implements IBikeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bike getBikeById(long bikeId) {
        return entityManager.find(Bike.class, bikeId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bike> getAllBikes() {
        String hql = "FROM Bike as bike";
        return (List<Bike>) entityManager.createQuery(hql).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bike> getAllBikesForUser() {
//        System.out.println("*****************************");
        String hql = "FROM Bike as bike WHERE bike.status = ?";
        return (List<Bike>) entityManager.createQuery(hql).setParameter(1, "available").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bike> getBikesByBrandAndStatus(String brand, String status) {
        System.out.println("*****************************");
        String hql = "FROM Bike as bike WHERE bike.brand = ? AND bike.status = ?";
        return (List<Bike>) entityManager.createQuery(hql).setParameter(1, brand).setParameter(2, status).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bike> getBikesBySusTypeAndStatus(String susType, String status) {
        System.out.println("*****************************");
        String hql = "FROM Bike as bike WHERE bike.susType = ? AND bike.status = ?";
        return (List<Bike>) entityManager.createQuery(hql).setParameter(1, susType).setParameter(2, status).getResultList();
    }

    @Override
    public void addBike(Bike bike) {
        entityManager.persist(bike);
    }

    @Override
    public void updateBike (Bike bike) {
        entityManager.flush();
    }


}
