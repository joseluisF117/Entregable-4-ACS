/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.PedidoProducto;
import com.uacm.ces.proyectofinal.modelo.Producto;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IPedidoProductoDao {

    public PedidoProducto buscarIdPedidoProductos(int id);

    public void agregarPedidoProducto(PedidoProducto PedidoProducto);

    public List<PedidoProducto> obtenerTodos(Pedido pedido);

}
