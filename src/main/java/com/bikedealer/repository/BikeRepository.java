package com.bikedealer.repository;

import com.bikedealer.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BikeRepository extends JpaRepository <Bike, Long> {

    @PreAuthorize("hasRole('ROLE_USER')")
    @Query(value = "SELECT b.bike_id, b.brand, b.model, b.wheel_size, b.price, b.sus_type, b.breaks, b.gears, b.sus_front, b.sus_rear, b.status FROM bikes b INNER JOIN bike_dealers_bike_list bd ON b.bike_id=bd.bike_list_bike_id WHERE bd.bike_dealer_bike_id=?1 AND b.status LIKE 'available'", nativeQuery = true)
    List<Bike> findAllByIdAndBikeAvailable(long id);

    @PreAuthorize("hasRole('ROLE_MOD') or hasRole('ROLE_ADMIN')")
    @Query(value = "SELECT b.bike_id, b.brand, b.model, b.wheel_size, b.price, b.sus_type, b.breaks, b.gears, b.sus_front, b.sus_rear, b.status FROM bikes b INNER JOIN bike_dealers_bike_list bd ON b.bike_id=bd.bike_list_bike_id WHERE bd.bike_dealer_bike_id=?1 AND b.status LIKE ?2", nativeQuery = true)
    List<Bike> findAllByIdAndBikeStatus(long id, String status);
}
