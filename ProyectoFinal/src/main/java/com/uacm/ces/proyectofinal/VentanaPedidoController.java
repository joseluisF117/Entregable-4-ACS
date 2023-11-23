/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.uacm.ces.proyectofinal;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.PedidoProducto;
import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.modelo.Ticket;
import com.uacm.ces.proyectofinal.modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author the_m
 */
public class VentanaPedidoController implements Initializable {

    @FXML
    private TableColumn tableViewColumnNombreProducto;
    @FXML
    private TableColumn tableViewColumnPiezasProducto;
    @FXML
    private TableView<PedidoProducto> tableViewPedidoProducto;
    @FXML
    private TableView<Producto> tableViewProducto;
    @FXML
    private TableColumn tableViewColumnSubtotal;
    @FXML
    private TableColumn<Producto, Object> tableViewColumnDescuento;
    private ObservableList<PedidoProducto> objPedidoProducto;
    private ObservableList<Producto> objProducto;
    private List<PedidoProducto> PedidoProductos = new ArrayList<PedidoProducto>();
    @FXML
    private Button btnPagarPedido;
    @FXML
    private Text txtTotalParcialPedido;
    @FXML
    private Text txtTotalPedido;
    @FXML
    private CheckBox checkTarjeta;
    @FXML
    private CheckBox checkEfectivo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        objPedidoProducto = FXCollections.observableArrayList();
        objProducto = FXCollections.observableArrayList();
        PedidoProducto pedidoProducto = new PedidoProducto();
        Pedido pedido = new Pedido();
        PedidoProductos = pedidoProducto.obtenerTodosPedidoProducto(pedido.buscarPedidoXEstado());
        this.tableViewColumnNombreProducto.setCellValueFactory(new PropertyValueFactory("producto"));
        this.tableViewColumnSubtotal.setCellValueFactory(new PropertyValueFactory("subtotalPagar"));
        this.tableViewColumnPiezasProducto.setCellValueFactory(new PropertyValueFactory("numeroPiezas"));
        this.tableViewColumnDescuento.setCellValueFactory(new PropertyValueFactory("porcentajeDescuento"));
        double subtotalPedido = 0;
        double totalPedido = 0;
        for (PedidoProducto pedidoPs : PedidoProductos) {
            Producto pro = null;
            Producto producto = new Producto();
            pro = producto.buscarProducto(pedidoPs.getProducto().getIdProducto());
            this.objPedidoProducto.add(pedidoPs);
            this.objProducto.add(pro);
            this.tableViewPedidoProducto.setItems(objPedidoProducto);
            this.tableViewProducto.setItems(objProducto);
            subtotalPedido = subtotalPedido + pedidoPs.getSubtotalPagar();
            double descuento = (pedidoPs.getSubtotalPagar() * (pro.getPorcentajeDescuento() / 100));
            totalPedido = totalPedido + (pedidoPs.getSubtotalPagar() - descuento);
        }
        txtTotalParcialPedido.setText(String.valueOf(String.format("%.2f", subtotalPedido)));
        txtTotalPedido.setText(String.valueOf(String.format("%.2f", totalPedido)));
        pedido.setTotalPagar(totalPedido);
        pedido.modificarPedido(pedido);
    }

    public void realizarPago() throws IOException {
        Pedido pedido = new Pedido();
        Pedido pedidoPendiente = pedido.buscarPedidoXEstado();
        String status = "completado";
        pedidoPendiente.modificarPedidoEstado(pedido, status);
        Ticket ticket = new Ticket();
        String nombreFiscal = "Farmaplus SA de CV";
        String domicilioFiscal = "San Lorenzo número 106, interior 301 Colonia "
                + "Tlacoquemecatl del Valle, Benito Juárez, Código Postal 03100, Ciudad de México";
        String rfc = "FFRRDD988776";
        String tipoPago = "Tarjeta";
        String piePagina = "Recuerda solicitar en los proximos 30 dias tu factura electronica";
        ticket.setPedido(pedidoPendiente);
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Javier");
        vendedor.setApellidoPaterno("Jimenez");
        vendedor.setIdVendedor(1);
        ticket.setVendedor(vendedor);
        ticket.setNombreFiscal(nombreFiscal);
        ticket.setDomicilioFiscal(domicilioFiscal);
        ticket.setRfc(rfc);
        ticket.setTipoPago(tipoPago);
        ticket.setLeyendaPiePagina(piePagina);
        Date fechaTicket = new Date();
        ticket.setFechaTicket(fechaTicket);
        ticket.guardarTicket(ticket);
        //VentanaTicketController con = new VentanaTicketController();
        //con.setTicket(ticket);
        App.setRoot("VentanaTicket");
    }
}
