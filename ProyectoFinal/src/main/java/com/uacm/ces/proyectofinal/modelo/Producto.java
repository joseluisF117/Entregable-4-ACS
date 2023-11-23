/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.modelo;

import com.uacm.ces.proyectofinal.persistencia.Dao.ProductoDaoImpl;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import com.uacm.ces.proyectofinal.persistencia.Dao.IProductoDao;
import java.util.List;

/**
 *
 * @author the_m
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int numeroPiezas;
    private String estado;
    private String informacionAdicional;
    private double porcentajeDescuento;
    private Vendedor vendedor;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String descripcion, double precio, int numeroPiezas, String estado, String informacionAdicional, double porcentajeDescuento, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.numeroPiezas = numeroPiezas;
        this.estado = estado;
        this.informacionAdicional = informacionAdicional;
        this.porcentajeDescuento = porcentajeDescuento;
        this.vendedor = vendedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return true;
    }

    public Producto buscarProducto(int id) {
        IProductoDao dao = new ProductoDaoImpl();
        Producto productoEncontrado = new Producto();
        productoEncontrado = dao.buscarProductoId(id);
        return productoEncontrado;
    }

    public Producto buscarProductoNombre(String nombre) {
        IProductoDao dao = new ProductoDaoImpl();
        Producto productoEncontrado = new Producto();
        productoEncontrado = dao.buscarProductoNombre(nombre);
        return productoEncontrado;
    }

    public void agregarProducto(Producto producto) {
        IProductoDao dao = new ProductoDaoImpl();
        dao.agregarProducto(producto);
    }

    public List<Producto> obtenerProductosNombre(String nombre) {
        IProductoDao dao = new ProductoDaoImpl();
        return dao.obtenerTodosProductosPornombre(nombre);
    }

}
