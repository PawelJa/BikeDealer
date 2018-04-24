package com.bikedealer.service;

import com.bikedealer.dao.IBikeDAO;
import com.bikedealer.entity.Bike;
import com.bikedealer.repository.BikeDealerRepository;
import com.bikedealer.dao.IBikeDealerDAO;
import com.bikedealer.entity.BikeDealer;
import com.bikedealer.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BikeDealerService implements IBikeDealerService {


    @Autowired
    private IBikeDealerDAO bikeDealerDAO;

    @Autowired
    private BikeDealerRepository bikeDealerRepository;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private IBikeDAO bikeDAO;
//    private String .;

    @Override
    public List<BikeDealer> getAllBikeDealers() {
        List<BikeDealer> list = bikeDealerRepository.findAll();
        return list;
    }

    @Override
    public List<Bike> findOneByIdAndBikeAvailable(long id){
        List<Bike> list = bikeRepository.findAllByIdAndBikeAvailable(id);
        Comparator<Bike> bikeComparator = (b1, b2) -> b1.getPrice().compareTo(b2.getPrice());
        list.sort(bikeComparator);
        return list;
    }

    @Override
    public List<Bike> findOneByIdAndBikeStatus(long id, String status){
        List<Bike> list = bikeRepository.findAllByIdAndBikeStatus(id, status);
        Comparator<Bike> bikeComparator = (b1, b2) -> b1.getBrand().compareTo(b2.getBrand());
        list.sort(bikeComparator);
        return list;
    }

    @Override
    public BikeDealer findOne(long id) {
        BikeDealer bikeDealer = bikeDealerRepository.findOne(id);
        return bikeDealer;
    }

    @Override
    public List<BikeDealer> findOneByName(String namePart) {
        Set<BikeDealer> list = bikeDealerRepository.findAllByNameContainsAndBikeListNotNull(namePart);
        for (BikeDealer item : list) {
            List<Bike> list1 = item.getBikeList();
            for (Bike item1 : list1) {
                if (item1.getStatus().equals("reserved")) {
                    item.getBikeList().remove(item1);
                }
            }
        }
        List<BikeDealer> list1 = new ArrayList<>();
        for (BikeDealer item : list) {
            list1.add(item);
        }
        Comparator<BikeDealer> bikeDealerComparator = (b1, b2) -> Integer.valueOf(b2.getBikeList().size()).compareTo(b1.getBikeList().size());
        list1.sort(bikeDealerComparator);
        return list1;
    }

    @Override
    public void addBikeDealer(BikeDealer bikeDealer) {
        bikeDealerDAO.addBikeDealer(bikeDealer);
    }

    @Override
    public void addBikeToBikeDealer(long bikeDealerId, long bikeId) {
        BikeDealer bikeDealer = bikeDealerRepository.findOne(bikeDealerId);
        List<Bike> list = bikeDealer.getBikeList();
        list.add(bikeDAO.getBikeById(bikeId));
        bikeDealerRepository.save(bikeDealer);
    }

    @Override
    public void updateBikeDealer(BikeDealer bikeDealer, long id) {
        BikeDealer bikeDealerToUp = bikeDealerRepository.findOne(id);
        bikeDealerToUp.setName(bikeDealer.getName());
        bikeDealerToUp.setAddress(bikeDealer.getAddress());
        bikeDealerToUp.setCity(bikeDealer.getCity());
        bikeDealerToUp.setPostcode(bikeDealer.getPostcode());
        bikeDealerRepository.save(bikeDealerToUp);
    }
}
