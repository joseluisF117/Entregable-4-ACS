/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.uacm.ces.proyectofinal;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.PedidoProducto;
import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.modelo.Ticket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class VentanaTicketController implements Initializable {

    @FXML
    private Text txtNombreFiscal;
    @FXML
    private Text txtRegimenFiscal;
    @FXML
    private Text txtDomicilioFiscal;
    @FXML
    private Text txtRFC;
    @FXML
    private Text txtLugarExpedicionTicket;
    @FXML
    private Text txtTipoCliente;
    @FXML
    private Text txtNombreVendedor;
    @FXML
    private Text txtVendedorCajero;

    private Ticket ticket;
    @FXML
    private TableView<Producto> tableViewProducto;
    @FXML
    private TableColumn<PedidoProducto, Integer> tableViewColumnCantidad;
    @FXML
    private TableColumn<Producto, String> tableViewColumnNombreProducto;
    @FXML
    private TableColumn<Producto, Double> tableViewColumnPrecio;
    @FXML
    private TableColumn<Producto, Double> tableViewColumnImporte;

    private ObservableList<PedidoProducto> objPedidoProducto;
    private ObservableList<Producto> objProducto;

    private List<PedidoProducto> PedidoProductos = new ArrayList<PedidoProducto>();

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        objPedidoProducto = FXCollections.observableArrayList();
        objProducto = FXCollections.observableArrayList();
        //System.out.println("this.ticket = " + this.ticket);
        //Pedido pedido = this.ticket.getPedido();
        PedidoProducto pedidoProducto = new PedidoProducto();
        //PedidoProductos = pedidoProducto.obtenerTodosPedidoProducto(pedido);
        this.tableViewColumnNombreProducto.setCellValueFactory(new PropertyValueFactory("producto"));
        this.tableViewColumnImporte.setCellValueFactory(new PropertyValueFactory("subtotalPagar"));
        this.tableViewColumnCantidad.setCellValueFactory(new PropertyValueFactory("numeroPiezas"));
        this.tableViewColumnPrecio.setCellValueFactory(new PropertyValueFactory("numeroPiezas"));
        for (PedidoProducto pedidoPs : PedidoProductos) {
            Producto producto = new Producto();
            Producto pro = null;
            this.objPedidoProducto.add(pedidoPs);
            this.objProducto.add(pro);
        }
    }

}
