/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.Usuario;
import com.uacm.ces.proyectofinal.persistencia.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class PedidoDaoImpl implements IPedidoDao {

    @Override
    public void agregarPedido(Pedido pedido) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        pedido.setUsuario(usuario);
        Conexion conexion = new Conexion();
        //String inserto = "INSERT INTO pedido (fechaHoraPedido, estatus, totalPagar, informacionAdicional) VALUES (?,?,?,?)";
        String inserto = "INSERT INTO pedido (fechaHoraPedido, estatus, idCliente, totalPagar, informacionAdicional) VALUES (?,?,?,?,?)";
        System.out.println("inserto = " + inserto);
        PreparedStatement stat = null;
        Connection conn = conexion.obtenerConecxion();

        try {
            stat = conn.prepareStatement(inserto);
            stat.setDate(1, new Date(pedido.getFechaHoraPedido().getTime()));
            stat.setString(2, pedido.getEstado());
            stat.setInt(3, pedido.getUsuario().getIdUsuario());
            stat.setDouble(4, pedido.getTotalPagar());
            stat.setString(5, "");
            //
            assert stat.executeUpdate() < 1 : stat.executeUpdate();
            System.out.println("stat.executeUpdate = " + stat.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Pedido buscarXEstadoPedido() {
        Conexion conexion = new Conexion();
        //Se tiene que generar el dao de Usuario se genera un objeto provisional
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        String sql = "SELECT * FROM pedido WHERE estatus = 'pendiente' AND idCliente= '" + usuario.getIdUsuario() + "';";
        System.out.println("sql = " + sql);
        Pedido pedido = new Pedido();

        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia;
            sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                pedido.setIdPedido(resultado.getInt("idPedido"));
                pedido.setFechaHoraPedido(resultado.getDate("fechaHoraPedido"));
                pedido.setEstado(resultado.getNString("estatus"));
                pedido.setUsuario(usuario);
                pedido.setTotalPagar(resultado.getDouble("totalPagar"));
                pedido.setInformacionAdicional(resultado.getString("informacionAdicional"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Resultado del query: pedidoXestado = " + pedido);
        return pedido;
    }

    @Override
    public void modificarPedido(Pedido pedido) {
        System.out.println("Dentro del metodo padre");
        Conexion conexion = new Conexion();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        String inserto = "UPDATE `pedido` SET `totalPagar` = ? WHERE estatus = 'pendiente' AND idCliente= '" + usuario.getIdUsuario() + "';";
        PreparedStatement stat = null;
        Connection conn = conexion.obtenerConecxion();
        try {
            stat = conn.prepareStatement(inserto);
            stat.setDouble(1, pedido.getTotalPagar());
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
    public void modificarPedidoEstado(Pedido pedido, String status) {
        System.out.println("Dentro del metodo sobrecargado");
        Conexion conexion = new Conexion();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        String inserto = "UPDATE `pedido` SET `estatus` = ? WHERE estatus = 'pendiente' AND idCliente= '" + usuario.getIdUsuario() + "';";
        PreparedStatement stat = null;
        Connection conn = conexion.obtenerConecxion();
        try {
            stat = conn.prepareStatement(inserto);
            stat.setString(1, status);
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
    public Pedido buscarXIdPedido(int id) {
        Conexion conexion = new Conexion();
        //Se tiene que generar el dao de Usuario se genera un objeto provisional
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        String sql = "SELECT * FROM pedido WHERE idPedido = '" + id + "'";
        System.out.println("sql = " + sql);
        Pedido pedido = new Pedido();

        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia;
            sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                pedido.setIdPedido(resultado.getInt("idPedido"));
                pedido.setFechaHoraPedido(resultado.getDate("fechaHoraPedido"));
                pedido.setEstado(resultado.getNString("estatus"));
                pedido.setUsuario(usuario);
                pedido.setTotalPagar(resultado.getDouble("totalPagar"));
                pedido.setInformacionAdicional(resultado.getString("informacionAdicional"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Resultado del query: pedidoXId = " + pedido);
        return pedido;
    }

}
