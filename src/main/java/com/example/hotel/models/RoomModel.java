package com.example.hotel.models;


import jakarta.persistence.*;

@Entity
@Table(name = "habitacion")
public class RoomModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitacionid;
    private Long hotelid;
    private int nivel;
    private int aforo;
    private int camaspersonales;
    private int camasdoble;
    private int precio;
    public Long getHotelId() {
        return hotelid;
    }

    public void setHotelId(Long hotelid) {
        this.hotelid = hotelid;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getCamasPersonales() {
        return camaspersonales;
    }

    public void setCamasPersonales(int camaspersonales) {
        this.camaspersonales = camaspersonales;
    }

    public int getCamasDoble() {
        return camasdoble;
    }

    public void setCamasDoble(int camasdoble) {
        this.camasdoble = camasdoble;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Long getHabitacionId() {
        return habitacionid;
    }
    public void setHabitacionId(Long habitacionid) {
        this.habitacionid = habitacionid;
    }
}
