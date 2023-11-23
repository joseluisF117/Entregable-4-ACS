/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Ticket;
import com.uacm.ces.proyectofinal.modelo.Vendedor;

/**
 *
 * @author ASUS
 */
public interface ITicketDao {

    public void guardarTicket(Ticket ticket);

    public Ticket buscarTicketUltimoPedidoVendedor(Vendedor vendedor);
}
