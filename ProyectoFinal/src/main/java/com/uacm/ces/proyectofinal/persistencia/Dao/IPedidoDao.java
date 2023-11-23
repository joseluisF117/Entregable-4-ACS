/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Pedido;

/**
 *
 * @author ASUS
 */
public interface IPedidoDao {

    public Pedido buscarXEstadoPedido();

    public void agregarPedido(Pedido pedido);
    
    public void modificarPedido(Pedido pedido);
    
    public void modificarPedidoEstado(Pedido pedido,String status);
    
    public Pedido buscarXIdPedido(int id);
}
