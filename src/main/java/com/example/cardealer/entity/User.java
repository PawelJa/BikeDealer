package com.example.cardealer.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="username")
    @NotEmpty
    private String userName;

    @NotEmpty
    @Column(name="password")
    private String password;

    @NotEmpty
    @Column(name="role")
    private String role;

    @NotEmpty
    @Column(name="full_name")
    private String fullName;

    @NotEmpty
    @Column(name="country")
    private String country;

    @NotEmpty
    @Column(name="enabled")
    private short enabled;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public short getEnabled() {
        return enabled;
    }
    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", fullName='" + fullName + '\'' +
                ", country='" + country + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
