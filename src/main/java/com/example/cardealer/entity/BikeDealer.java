package com.example.cardealer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="bikeDealer")
public class BikeDealer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "error.bikedealer.notempty")
    private String name;

    @NotEmpty(message = "error.bikedealer.notempty")
    private String address;

    @NotEmpty(message = "error.bikedealer.notempty")
    private String city;

    @NotEmpty
    @Pattern(regexp = "[0-9][0-9]/-[0-9][0-9][0-9]", message = "postcode must be in format: xx-xxx")
    private String postcode;

    private List<Bike> bikesList;

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

    public List<Bike> getBikesList() {
        return bikesList;
    }

    public void setBikesList(List<Bike> bikesList) {
        this.bikesList = bikesList;
    }

    public BikeDealer() {
    }
}
