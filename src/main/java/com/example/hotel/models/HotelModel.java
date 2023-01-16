package com.example.hotel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelid;
    private String direccion;
    private int niveles;
    private String distrito;
    private String ciudad;

    public Long getHotelId() {
        return hotelid;
    }

    public void setHotelId(Long hotelid) {
        this.hotelid = hotelid;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
