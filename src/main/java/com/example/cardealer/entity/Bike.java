package com.example.cardealer.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "error.bike.notempty")
    private String brand;

    @NotEmpty(message = "error.bike.notempty")
    private String model;

    @NotEmpty(message = "error.bike.notempty")
//    @Pattern("")
    @Size(min=2, max=3, message = "error.bike.size")
    @Column(scale = 1)
    private double wheelSize;

    @NotEmpty(message = "error.bike.notempty")
    @Column(scale = 2)
    private double price;

    @NotEmpty(message = "error.bike.notempty")
    private String susType;

    @NotEmpty(message = "error.bike.notempty")
    private String breaks;

    @NotEmpty(message = "error.bike.notempty")
    private String gears;

    @Nullable
    private String susFront;

    @Nullable
    private String susRear;

    @NotEmpty(message = "error.bike.notempty")
    private String status;

    public long getId() {
        return id;
    }

    public Bike() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSusType() {
        return susType;
    }

    public void setSusType(String susType) {
        this.susType = susType;
    }

    public String getBreaks() {
        return breaks;
    }

    public void setBreaks(String breaks) {
        this.breaks = breaks;
    }

    public String getGears() {
        return gears;
    }

    public void setGears(String gears) {
        this.gears = gears;
    }

    public String getSusFront() {
        return susFront;
    }

    public void setSusFront(String susFront) {
        this.susFront = susFront;
    }

    public String getSusRear() {
        return susRear;
    }

    public void setSusRear(String susRear) {
        this.susRear = susRear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", wheelSize=" + wheelSize +
                ", price=" + price +
                ", susType='" + susType + '\'' +
                ", breaks='" + breaks + '\'' +
                ", gears='" + gears + '\'' +
                ", susFront='" + susFront + '\'' +
                ", susRear='" + susRear + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
