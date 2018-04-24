package com.bikedealer.service;

import com.bikedealer.entity.Bike;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IBikeService {

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD') or hasRole('ROLE_USER')")
    List<Bike> getAllBikes(String username);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD')")
    List<Bike> getBikesByBrandAndStatus(String brand, String status);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD')")
    List<Bike> getBikesBySusTypeAndStatus(String susType, String status);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addBike(Bike bike);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD')")
    void updateBike(Bike bike, long id);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD') or hasRole('ROLE_USER')")
    Bike getBikeById(long id);
}
