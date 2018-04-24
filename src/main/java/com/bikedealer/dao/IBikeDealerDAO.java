package com.bikedealer.dao;

import com.bikedealer.entity.BikeDealer;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IBikeDealerDAO {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addBikeDealer (BikeDealer bikeDealer);
//
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MOD') or hasRole('ROLE_USER')")
//    List<BikeDealer> getAllBikeDealers();
}
