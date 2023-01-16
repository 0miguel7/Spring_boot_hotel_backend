package com.example.hotel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class ReservaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservaid")
    private Long reservaid;
    private Long habitacionid;
    private Long usuarioid;
    private String inicio;
    private String fin;

    public Long getReservaId() {
        return reservaid;
    }

    public void setReservaId(Long reservaid) {
        this.reservaid = reservaid;
    }

    public Long getHabitacionId() {
        return habitacionid;
    }

    public void setHabitacionId(Long habitacionid) {
        this.habitacionid = habitacionid;
    }

    public Long getUsuarioId() {
        return usuarioid;
    }

    public void setUsuarioId(Long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

}
