package com.bikedealer.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="bikes")
public class Bike implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bike_id")
    private long id;

    @NotEmpty(message = "error.bike.notnull")
    private String brand;

    @NotEmpty(message = "error.bike.notnull")
    private String model;

    @Digits(integer = 2, fraction = 1, message = "error.bike.wheelSize")
    private BigDecimal wheelSize;

    @Digits(integer = 10, fraction = 2,message = "error.bike.price")
    private BigDecimal price;

    @NotEmpty(message = "error.bike.notnull")
    private String susType;

    @NotEmpty(message = "error.bike.notnull")
    private String breaks;

    @NotEmpty(message = "error.bike.notnull")
    private String gears;

    @NotEmpty(message = "error.bike.notnull")
    private String susFront;

    @NotEmpty(message = "error.bike.notnull")
    private String susRear;

    @NotEmpty(message = "error.bike.notnull")
    private String status;


    public Bike() {
    }

    public long getId() {
        return id;
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

    public BigDecimal getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(BigDecimal wheelSize) {
        this.wheelSize = wheelSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
