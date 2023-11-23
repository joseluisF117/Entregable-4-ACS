/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.modelo;

import java.util.Date;

/**
 *
 * @author the_m
 */
public class Usuario {

    protected int idUsuario;
    protected String nombre;
    protected String apellidoPaterno;
    protected String appelidoMaterno;
    protected String rfc;
    protected Date fechaIngreso;
    protected int estatus;
    protected int puesto;
    protected Date fechaIngresoPuesto;

    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String appelidoMaterno, String rfc, Date fechaIngreso, int estatus, int puesto, Date fechaIngresoPuesto) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.appelidoMaterno = appelidoMaterno;
        this.rfc = rfc;
        this.fechaIngreso = fechaIngreso;
        this.estatus = estatus;
        this.puesto = puesto;
        this.fechaIngresoPuesto = fechaIngresoPuesto;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getAppelidoMaterno() {
        return appelidoMaterno;
    }

    public void setAppelidoMaterno(String appelidoMaterno) {
        this.appelidoMaterno = appelidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public Date getFechaIngresoPuesto() {
        return fechaIngresoPuesto;
    }

    public void setFechaIngresoPuesto(Date fechaIngresoPuesto) {
        this.fechaIngresoPuesto = fechaIngresoPuesto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", appelidoMaterno=" + appelidoMaterno + ", rfc=" + rfc + ", fechaIngreso=" + fechaIngreso + ", estatus=" + estatus + ", puesto=" + puesto + ", fechaIngresoPuesto=" + fechaIngresoPuesto + '}';
    }

}
