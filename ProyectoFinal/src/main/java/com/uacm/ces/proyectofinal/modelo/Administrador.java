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
public class Administrador extends Empleado {

    public Administrador(int idUsuario, String nombre, String apellidoPaterno, String appelidoMaterno, String rfc, Date fechaIngreso, int estatus, int puesto, Date fechaIngresoPuesto) {
        super(idUsuario, nombre, apellidoPaterno, appelidoMaterno, rfc, fechaIngreso, estatus, puesto, fechaIngresoPuesto);
    }

    public Administrador() {
    }

}
