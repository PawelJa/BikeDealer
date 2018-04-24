package com.bikedealer.service;

import com.bikedealer.entity.Bike;
import com.bikedealer.dao.IBikeDAO;
import com.bikedealer.entity.UserInfo;
import com.bikedealer.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BikeService implements IBikeService {

    @Autowired
    private IBikeDAO bikeDAO;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<Bike> getAllBikes(String username){
        System.out.println("***********service");
        UserInfo activeUser = userInfoRepository.findByUserName(username);
        String role = activeUser.getRole();
        System.out.println(activeUser.getUserName() + " **** " + activeUser.getRole());
        List<Bike> list = new ArrayList<>();
        if (role.equals("ROLE_USER")) {
            list = bikeDAO.getAllBikesForUser();
        } else {
            list = bikeDAO.getAllBikes();
        }
        return list;
    }

    @Override
    public List<Bike> getBikesByBrandAndStatus(String brand, String status) {
        List<Bike> list = bikeDAO.getBikesByBrandAndStatus(brand, status);
        Collections.sort(list, new Comparator<Bike>() {
            @Override
            public int compare(Bike b1, Bike b2) {
                return b1.getPrice().compareTo(b2.getPrice()); // sort by price; higher first
            }
        });

        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Bike> getBikesBySusTypeAndStatus(String susType, String status) {
        List<Bike> list = bikeDAO.getBikesBySusTypeAndStatus(susType, status);
        Collections.sort(list, new Comparator<Bike>() {
            @Override
            public int compare(Bike b1, Bike b2) {
                return b1.getWheelSize().compareTo(b2.getWheelSize()); // sort by wheelSize; smaller first
            }
        });

        return list;
    }

    @Override
    public void addBike(Bike bike) {
        bikeDAO.addBike(bike);
    }

    @Override
    public void updateBike(Bike bike, long id) {
        Bike bikeToUp = getBikeById(id);
        bikeToUp.setBrand(bike.getBrand());
        bikeToUp.setModel(bike.getModel());
        bikeToUp.setWheelSize(bike.getWheelSize());
        bikeToUp.setPrice(bike.getPrice());
        bikeToUp.setSusType(bike.getSusType());
        bikeToUp.setBreaks(bike.getBreaks());
        bikeToUp.setGears(bike.getGears());
        bikeToUp.setSusFront(bike.getSusFront());
        bikeToUp.setSusRear(bike.getSusRear());
        bikeToUp.setStatus(bike.getStatus());
        bikeDAO.updateBike(bikeToUp);
    }

    @Override
    public Bike getBikeById(long id) {
        return bikeDAO.getBikeById(id);
    }
}
