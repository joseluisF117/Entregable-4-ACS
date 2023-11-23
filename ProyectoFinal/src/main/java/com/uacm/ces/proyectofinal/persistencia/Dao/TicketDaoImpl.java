/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.modelo.Ticket;
import com.uacm.ces.proyectofinal.modelo.Vendedor;
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
public class TicketDaoImpl implements ITicketDao {

    @Override
    public void guardarTicket(Ticket ticket) {
        Conexion conexion = new Conexion();
        String inserto = "INSERT INTO ticket (idPedido, idVendedor, nombre_fiscal, domicilio_fiscal, RFC, tipo_pago, fecha_ticket, leyenda_pie_pagina)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stat = null;
        Connection conn = conexion.obtenerConecxion();

        try {
            stat = conn.prepareStatement(inserto);
            stat.setInt(1, ticket.getPedido().getIdPedido());
            stat.setInt(2, ticket.getVendedor().getIdVendedor());
            stat.setString(3, ticket.getNombreFiscal());
            stat.setString(4, ticket.getDomicilioFiscal());
            stat.setString(5, ticket.getRfc());
            stat.setString(6, ticket.getTipoPago());
            stat.setDate(7, new Date(ticket.getFechaTicket().getTime()));
            stat.setString(8, ticket.getLeyendaPiePagina());
            assert stat.executeUpdate() < 1 : stat.executeUpdate();
            System.out.println("stat.executeUpdate = " + stat.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(TicketDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Ticket buscarTicketUltimoPedidoVendedor(Vendedor vendedor) {
        Conexion conexion = new Conexion();
        Producto producto = null;
        Pedido pedido = new Pedido();
        Ticket ticket = new Ticket();
        String sql = "SELECT * FROM ticket WHERE " + vendedor.getIdVendedor() + " ORDER BY idPedido DESC LIMIT 1";
        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                ticket.setIdTicket(resultado.getInt("idTicket"));
                
                Pedido ped = null;
                //ped = pedido.buscarXIdPedido();
                
                ticket.setPedido(pedido);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ticket;
    }

}
