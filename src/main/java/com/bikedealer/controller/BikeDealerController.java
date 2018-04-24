package com.bikedealer.controller;

import com.bikedealer.service.IBikeDealerService;
import com.bikedealer.entity.BikeDealer;
import com.bikedealer.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/bikeDealer")
public class BikeDealerController {

    @Autowired
    private IBikeDealerService bikeDealerService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("")
    public ResponseEntity<List<BikeDealer>> getAllBikeDealers(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        System.out.println(principal.getName());
        List<BikeDealer> list = bikeDealerService.getAllBikeDealers();
        return new ResponseEntity<List<BikeDealer>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BikeDealer> getById(@PathVariable long id) {
//        Principal principal = request.getUserPrincipal();
//        System.out.println(principal.getName());
//        System.out.println(userInfoRepository.findByUserName(principal.getName()).getRole());
        BikeDealer bikeDealer = bikeDealerService.findOne(id);
        if (bikeDealer == null) {
            return new ResponseEntity<>(bikeDealer, HttpStatus.NOT_FOUND);
        }
        bikeDealer.setBikeList(bikeDealerService.findOneByIdAndBikeAvailable(id));
        return new ResponseEntity<BikeDealer>(bikeDealer, HttpStatus.OK);
    }

    @GetMapping("/{id}/status/{status}")
    public ResponseEntity <BikeDealer> getByIdWithStatus(@PathVariable long id, @PathVariable String status) {
        BikeDealer bikeDealer = bikeDealerService.findOne(id);
        if (!status.equals("all")) {
            bikeDealer.setBikeList(bikeDealerService.findOneByIdAndBikeStatus(id, status));
        }
        return new ResponseEntity<BikeDealer>(bikeDealer, HttpStatus.OK);
    }

    @GetMapping("/nameLike/{namePart}")
    public ResponseEntity<List<BikeDealer>> getByName(@PathVariable String namePart) {
        List<BikeDealer> list = bikeDealerService.findOneByName(namePart);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addBikeDealer(@Validated @RequestBody BikeDealer bikeDealer, UriComponentsBuilder builder) {
        bikeDealerService.addBikeDealer(bikeDealer);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/bike/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(HttpStatus.CREATED );
    }

    @PostMapping("/{bikeDelaerId}/{bikeId}")
    public ResponseEntity<Void> addBikeToBikeDealer(@PathVariable long bikeDelaerId, @PathVariable long bikeId) {
        bikeDealerService.addBikeToBikeDealer(bikeDelaerId, bikeId);
        return new ResponseEntity<Void>(HttpStatus.CREATED );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBikeDealer(@Validated @RequestBody BikeDealer bikeDealer, @PathVariable long id) {
        bikeDealerService.updateBikeDealer(bikeDealer, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
