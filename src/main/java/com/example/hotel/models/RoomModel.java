package com.example.hotel.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class RoomModel {


    @Id
    private long habitacionid;
    private long hotelid;
    private int nivel;
    private int aforo;
    private int camaspersonales;
    private int camasdoble;
    private int precio;
    public long getHotelid() {
        return hotelid;
    }

    public void setHotelid(long hotelid) {
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

    public int getCamaspersonales() {
        return camaspersonales;
    }

    public void setCamaspersonales(int camaspersonales) {
        this.camaspersonales = camaspersonales;
    }

    public int getCamasdoble() {
        return camasdoble;
    }

    public void setCamasdoble(int camasdoble) {
        this.camasdoble = camasdoble;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public long getHabitacionid() {
        return habitacionid;
    }

    public void setHabitacionid(long habitacionid) {
        this.habitacionid = habitacionid;
    }
}
