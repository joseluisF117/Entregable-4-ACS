/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.modelo;

import com.uacm.ces.proyectofinal.persistencia.Dao.IPedidoDao;
import com.uacm.ces.proyectofinal.persistencia.Dao.PedidoDaoImpl;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Pedido {

    private int idPedido;
    private Date fechaHoraPedido;
    private String estado;
    private Usuario usuario;
    private double totalPagar;
    private String informacionAdicional;

    public Pedido(int idPedido, Date fechaHoraPedido, String estado, Usuario usuario, double totalPagar, String informacionAdicional) {
        this.idPedido = idPedido;
        this.fechaHoraPedido = fechaHoraPedido;
        this.estado = estado;
        this.usuario = usuario;
        this.totalPagar = totalPagar;
        this.informacionAdicional = informacionAdicional;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fechaHoraPedido=" + fechaHoraPedido + ", estado=" + estado + ", usuario=" + usuario + ", totalPagar=" + totalPagar + ", informacionAdicional=" + informacionAdicional + '}';
    }

    public void guardarPedido(Pedido pedido) {
        IPedidoDao dao = new PedidoDaoImpl();
        dao.agregarPedido(pedido);
    }

    public Pedido buscarPedidoXEstado() {
        IPedidoDao dao = new PedidoDaoImpl();
        Pedido pedido = new Pedido();
        pedido = dao.buscarXEstadoPedido();
        return pedido;
    }

    public void modificarPedido(Pedido pedido) {
        IPedidoDao dao = new PedidoDaoImpl();
        dao.modificarPedido(pedido);
    }
    
    public void modificarPedidoEstado(Pedido pedido,String status) {
        IPedidoDao dao = new PedidoDaoImpl();
        dao.modificarPedidoEstado(pedido,status);
    }

}
