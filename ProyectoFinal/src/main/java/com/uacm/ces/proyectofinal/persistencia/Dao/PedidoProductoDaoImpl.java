/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia.Dao;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.PedidoProducto;
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
 * @author ASUS
 */
public class PedidoProductoDaoImpl implements IPedidoProductoDao {

    @Override
    public PedidoProducto buscarIdPedidoProductos(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarPedidoProducto(PedidoProducto pedidoProducto) {
        Conexion conexion = new Conexion();
        String inserto = "INSERT INTO pedidosproductos (idPedidoProducto, idPedido, idProducto, numeroPiezas, subtotalPagar) VALUES (?,?,?,?,?);";
        System.out.println("inserto = " + inserto);
        PreparedStatement stat = null;
        Connection conn = conexion.obtenerConecxion();

        try {
            stat = conn.prepareStatement(inserto);
            stat.setInt(1, pedidoProducto.getIdPedidoProducto());
            stat.setInt(2, pedidoProducto.getPedido().getIdPedido());
            stat.setInt(3, pedidoProducto.getProducto().getIdProducto());
            stat.setInt(4, pedidoProducto.getNumeroPiezas());
            stat.setDouble(5, pedidoProducto.getSubtotalPagar());
            

            assert stat.executeUpdate() < 1 : stat.executeUpdate();
            System.out.println("stat.executeUpdate = " + stat.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(PedidoProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PedidoProducto> obtenerTodos(Pedido pedido) {
        Conexion conexion = new Conexion();
        List<PedidoProducto> listPedidoProductos = new ArrayList<>();
        String sql = "SELECT * FROM pedidosproductos WHERE idPedido =" + pedido.getIdPedido();

        try {
            Connection conn = conexion.obtenerConecxion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            IProductoDao dao = new ProductoDaoImpl();
            while (resultado.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(resultado.getInt("idPedidoProducto" ));
                pedidoProducto.setPedido(pedido);
                pedidoProducto.setProducto(dao.buscarProductoId(resultado.getInt("idProducto" )));
                pedidoProducto.setNumeroPiezas(resultado.getInt("numeroPiezas"));
                pedidoProducto.setSubtotalPagar(resultado.getDouble("subtotalPagar"));
                listPedidoProductos.add(pedidoProducto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPedidoProductos;
    }

}
