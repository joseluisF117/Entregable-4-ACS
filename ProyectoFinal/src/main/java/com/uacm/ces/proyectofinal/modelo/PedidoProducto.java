/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.modelo;

import com.uacm.ces.proyectofinal.persistencia.Dao.IPedidoProductoDao;
import com.uacm.ces.proyectofinal.persistencia.Dao.PedidoProductoDaoImpl;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PedidoProducto {

    private int idPedidoProducto;
    private Pedido pedido;
    private Producto producto;
    private int numeroPiezas;
    private double subtotalPagar;

    public PedidoProducto() {
    }

    public PedidoProducto(int idPedidoProducto, Pedido pedido, Producto producto, int numeroPiezas, double subtotalPagar) {
        this.idPedidoProducto = idPedidoProducto;
        this.pedido = pedido;
        this.producto = producto;
        this.numeroPiezas = numeroPiezas;
        this.subtotalPagar = subtotalPagar;
    }

    public int getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public void setIdPedidoProducto(int idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public double getSubtotalPagar() {
        return subtotalPagar;
    }

    public void setSubtotalPagar(double subtotalPagar) {
        this.subtotalPagar = subtotalPagar;
    }

    @Override
    public String toString() {
        return "PedidoProducto{" + "idPedidoProducto=" + idPedidoProducto + ", pedido=" + pedido + ", producto=" + producto + ", numeroPiezas=" + numeroPiezas + ", subtotalPagar=" + subtotalPagar + '}';
    }

    public void agregarPedidoProductos(PedidoProducto pedidoProducto) {
        IPedidoProductoDao dao = new PedidoProductoDaoImpl();
        dao.agregarPedidoProducto(pedidoProducto);
    }

    public List<PedidoProducto> obtenerTodosPedidoProducto(Pedido idPedido) {
        IPedidoProductoDao dao = new PedidoProductoDaoImpl();
        return dao.obtenerTodos(idPedido);
    }

}
