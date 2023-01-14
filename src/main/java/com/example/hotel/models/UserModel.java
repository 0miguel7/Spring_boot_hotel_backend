package com.example.hotel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UserModel {

    @Id/*
    @GeneratedValue
    @Column(unique = true,nullable = false)*/
    private long usuarioid;
    private String nombres;
    private String apellidos;
    private String correo;
    private long telefono;
    private String password;

    public long getUsuarioId() {
        return usuarioid;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioid = usuarioId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
