package com.bikedealer.repository;

import com.bikedealer.entity.BikeDealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Set;

public interface BikeDealerRepository extends JpaRepository <BikeDealer, Long> {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    BikeDealer save(BikeDealer bikeDealer);

    @PreAuthorize("hasRole('ROLE_MOD') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    BikeDealer findOne(long id);

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MOD', 'ROLE_USER')")
//    List<BikeDealer> findOneByNameContainingAndBikeListIsNotNull(String namePart);

    @PreAuthorize("hasRole('ROLE_MOD') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    Set<BikeDealer> findAllByNameContainsAndBikeListNotNull(String namePart);


}
