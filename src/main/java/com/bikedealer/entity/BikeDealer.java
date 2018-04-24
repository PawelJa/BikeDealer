package com.bikedealer.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bikeDealers")
public class BikeDealer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bike_id")
    private long id;

    @NotEmpty(message = "error.bikeDealer.notEmpty")
    private String name;

    @NotEmpty(message = "error.bikeDealer.notEmpty")
    private String address;

    @NotEmpty(message = "error.bikeDealer.notEmpty")
    private String city;

    @NotEmpty(message = "error.bikeDealer.notEmpty")
    @Pattern(regexp = "[0-9][0-9]\\-[0-9][0-9][0-9]", message = "error.bikeDealer.postCode")
    private String postcode;

    @OneToMany
    private List<Bike> bikeList = new ArrayList<>();



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    public BikeDealer() {
    }
}
