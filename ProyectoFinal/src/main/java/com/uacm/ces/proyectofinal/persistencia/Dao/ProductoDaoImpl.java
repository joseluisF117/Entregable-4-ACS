/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author the_m
 */
public class ProductoDaoImpl implements IProductoDao {

    List<Producto> productos = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        producto.setVendedor(null);
        Conexion conexion = new Conexion();
        String inserto = "INSERT INTO producto (nombreProducto, descripcionProducto, "
                + "precioProducto, numeroPiezas, " + "estadoProducto, porcentajeDescuento, informacionAdicional) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stat = null;
        Connection conn = conexion.obtenerConecxion();
        try {
            stat = conn.prepareStatement(inserto);
            stat.setString(1, producto.getNombre());
            stat.setString(2, producto.getDescripcion());
            stat.setDouble(3, producto.getPrecio());
            stat.setInt(4, producto.getNumeroPiezas());
            stat.setString(5, producto.getEstado());
            stat.setDouble(6, producto.getPorcentajeDescuento());
            stat.setString(7, producto.getInformacionAdicional());
            //stat.setInt(7, producto.getVendedor().getIdVendedor());
            assert stat.executeUpdate() < 1 : stat.executeUpdate();
            System.out.println("stat.executeUpdate = " + stat.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Producto buscarProductoId(int id) {
        Conexion conexion = new Conexion();
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE idProducto = '" + id + "';";
        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            producto = new Producto();
            while (resultado.next()) {
                producto.setIdProducto(resultado.getInt("idProducto"));
                producto.setNombre(resultado.getString("nombreProducto"));
                producto.setDescripcion(resultado.getString("descripcionProducto"));
                producto.setPrecio(resultado.getDouble("precioProducto"));
                producto.setNumeroPiezas(resultado.getInt("numeroPiezas"));
                producto.setEstado(resultado.getNString("estadoProducto"));
                producto.setPorcentajeDescuento(resultado.getDouble("porcentajeDescuento"));
                producto.setInformacionAdicional(resultado.getNString("informacionAdicional"));
                producto.setVendedor(null);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    @Override
    public Producto buscarProductoNombre(String nombre) {

        Conexion conexion = new Conexion();
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE nombreProducto LIKE '%" + nombre + "%'"; //collate Latin1_General_CI_AI

        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                producto = new Producto();
                producto.setIdProducto(resultado.getInt("idProducto"));
                producto.setNombre(resultado.getString("nombreProducto"));
                producto.setDescripcion(resultado.getString("descripcionProducto"));
                producto.setPrecio(resultado.getDouble("precioProducto"));
                producto.setNumeroPiezas(resultado.getInt("numeroPiezas"));
                producto.setEstado(resultado.getNString("estadoProducto"));
                producto.setPorcentajeDescuento(resultado.getDouble("porcentajeDescuento"));
                producto.setInformacionAdicional(resultado.getNString("informacionAdicional"));
                producto.setVendedor(null);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerTodosProductosPornombre(String nombre) {
        Conexion conexion = new Conexion();
        List<Producto> listProductos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombreProducto LIKE '%" + nombre + "%'";
        Producto producto = null;
        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                producto = new Producto();
                producto.setIdProducto(resultado.getInt("idProducto"));
                producto.setNombre(resultado.getString("nombreProducto"));
                producto.setDescripcion(resultado.getString("descripcionProducto"));
                producto.setPrecio(resultado.getDouble("precioProducto"));
                producto.setNumeroPiezas(resultado.getInt("numeroPiezas"));
                producto.setEstado(resultado.getNString("estadoProducto"));
                producto.setPorcentajeDescuento(resultado.getDouble("porcentajeDescuento"));
                producto.setInformacionAdicional(resultado.getNString("informacionAdicional"));
                producto.setVendedor(null);
                listProductos.add(producto);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProductos;
    }

}
