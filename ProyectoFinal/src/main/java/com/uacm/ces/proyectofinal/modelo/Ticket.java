/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.modelo;

import com.uacm.ces.proyectofinal.persistencia.Dao.ITicketDao;
import com.uacm.ces.proyectofinal.persistencia.Dao.TicketDaoImpl;
import java.util.Date;

/**
 *
 * @author the_m
 */
public class Ticket {

    private int idTicket;
    private Pedido pedido;
    private String nombreFiscal;
    private String domicilioFiscal;
    private String rfc;
    private String tipoPago;
    private Date fechaTicket;
    private String leyendaPiePagina;
    private Vendedor vendedor;

    public Ticket(int idTicket, Pedido pedido, String nombreFiscal, String domicilioFiscal, String rfc, String tipoPago, Date fechaTicket, String leyendaPiePagina, Vendedor vendedor) {
        this.idTicket = idTicket;
        this.pedido = pedido;
        this.nombreFiscal = nombreFiscal;
        this.domicilioFiscal = domicilioFiscal;
        this.rfc = rfc;
        this.tipoPago = tipoPago;
        this.fechaTicket = fechaTicket;
        this.leyendaPiePagina = leyendaPiePagina;
        this.vendedor = vendedor;
    }

    public Ticket() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNombreFiscal() {
        return nombreFiscal;
    }

    public void setNombreFiscal(String nombreFiscal) {
        this.nombreFiscal = nombreFiscal;
    }

    public String getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(String domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaTicket() {
        return fechaTicket;
    }

    public void setFechaTicket(Date fechaTicket) {
        this.fechaTicket = fechaTicket;
    }

    public String getLeyendaPiePagina() {
        return leyendaPiePagina;
    }

    public void setLeyendaPiePagina(String leyendaPiePagina) {
        this.leyendaPiePagina = leyendaPiePagina;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", pedido=" + pedido + ", nombreFiscal=" + nombreFiscal + ", domicilioFiscal=" + domicilioFiscal + ", rfc=" + rfc + ", tipoPago=" + tipoPago + ", fechaTicket=" + fechaTicket + ", leyendaPiePagina=" + leyendaPiePagina + ", vendedor=" + vendedor + '}';
    }
    
    public void guardarTicket(Ticket ticket){
        ITicketDao dao = new TicketDaoImpl();
        dao.guardarTicket(ticket);
    }

}
