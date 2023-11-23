/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author the_m
 */
public interface IProductoDao {

    public void agregarProducto(Producto producto);

    public Producto buscarProductoId(int id);

    public Producto buscarProductoNombre(String nombre);

    public List<Producto> obtenerTodosProductosPornombre(String nombre);
}
