package com.bikedealer.controller;

import com.bikedealer.entity.Bike;
import com.bikedealer.service.IBikeService;
import com.bikedealer.config.AppAuthenticationEntryPoint;
import com.bikedealer.config.MyAppUserDetailsService;
import com.bikedealer.dao.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private IBikeService bikeService;

    @Autowired
    private AppAuthenticationEntryPoint appAuthenticationEntryPoint;

    @Autowired
    private MyAppUserDetailsService myAppUserDetailsService;

    @Autowired
    private UserInfoDAO userInfoDAO;

    @GetMapping("")
    public ResponseEntity<List<Bike>> getAllBikes(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        System.out.println(principal.getName());
        List<Bike> list = bikeService.getAllBikes(principal.getName());
        return new ResponseEntity<List<Bike>>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addBike(@Validated @RequestBody Bike bike, UriComponentsBuilder builder) {
        bikeService.addBike(bike);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/bike/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(HttpStatus.CREATED );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@Validated @RequestBody Bike bike, @PathVariable long id) {
        bikeService.updateBike(bike, id);
        return new ResponseEntity<Bike>(bike, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable long id) {
        Bike bike = bikeService.getBikeById(id);
        if (bike == null) {
            return new ResponseEntity<>(bike, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bike, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/status/{status}")
    public ResponseEntity<List<Bike>> getBikesByBrandAndStatus(@PathVariable String brand, @PathVariable String status) {
        List<Bike> list = bikeService.getBikesByBrandAndStatus(brand, status);
        return new ResponseEntity<List<Bike>>(list, HttpStatus.OK);
    }

    @GetMapping("/susType/{susType}/status/{status}")
    public ResponseEntity<List<Bike>> getBikesBySusTypeAndStatus(@PathVariable String susType, @PathVariable String status) {
        List<Bike> list = bikeService.getBikesBySusTypeAndStatus(susType, status);
        return new ResponseEntity<List<Bike>>(list, HttpStatus.OK);
    }

        @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Contact not found*****")
    public void notFound() { }

}
