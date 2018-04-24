package com.bikedealer.dao;

import com.bikedealer.entity.Bike;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IBikeDAO {

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_MOD')")
    List<Bike> getAllBikes();

    @PreAuthorize("hasRole('ROLE_USER')")
    List<Bike> getAllBikesForUser();

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD')")
    List<Bike> getBikesByBrandAndStatus(String brand, String status);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD')")
    List<Bike> getBikesBySusTypeAndStatus(String susType, String status);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addBike (Bike bike);

    @PreAuthorize("hasRole('ROLE_MOD') or hasRole('ROLE_ADMIN')")
    void updateBike(Bike bike);

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD') or hasRole('ROLE_USER')")
    Bike getBikeById(long id);


}
