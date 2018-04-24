package com.bikedealer.service;

import com.bikedealer.entity.Bike;
import com.bikedealer.entity.BikeDealer;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IBikeDealerService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<BikeDealer> getAllBikeDealers();

    @PreAuthorize("hasRole('ROLE_USER')")
    List <Bike> findOneByIdAndBikeAvailable(long id);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD')")
    List <Bike> findOneByIdAndBikeStatus(long id, String status);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    BikeDealer findOne(long id);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    List<BikeDealer> findOneByName(String name);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addBikeDealer(BikeDealer bikeDealer);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addBikeToBikeDealer (long bikeDealerId, long bikeId);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void updateBikeDealer(BikeDealer bikeDealer, long id);
}
