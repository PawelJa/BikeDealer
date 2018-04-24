package com.bikedealer.dao;

import com.bikedealer.entity.BikeDealer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class BikeDealerDAO implements IBikeDealerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBikeDealer(BikeDealer bikeDealer) {
        entityManager.persist(bikeDealer);
    }
//
//    @Override
//    public List<BikeDealer> getAllBikeDealers() {
//        String hql = "FROM BikeDealer as bikeDealer";
//        return (List<BikeDealer>) entityManager.createQuery(hql).getResultList();
//    }

}
