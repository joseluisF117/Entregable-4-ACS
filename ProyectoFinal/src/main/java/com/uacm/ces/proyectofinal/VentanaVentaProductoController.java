/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.uacm.ces.proyectofinal;

import com.uacm.ces.proyectofinal.modelo.Pedido;
import com.uacm.ces.proyectofinal.modelo.PedidoProducto;
import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.modelo.excepciones.MiExcepcion;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author the_m
 */
public class VentanaVentaProductoController implements Initializable {

    @FXML
    private TextField txtFieldBuscarProducto;
    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn tableViewColumnDescripcionProducto;

    @FXML
    private TableColumn tableViewColumnDsiponibilidadProducto;

    @FXML
    private TableColumn tableViewColumnInfoAdicionalProducto;

    @FXML
    private TableColumn tableViewColumnNombreProducto;

    @FXML
    private TableColumn tableViewColumnPiezasProducto;

    @FXML
    private TableColumn tableViewColumnPrecioUnitarioProducto;

    @FXML
    private TableView<Producto> tableViewProductos;

    private ObservableList<Producto> objProductos;
    @FXML
    private Button btnAgregarProducto;

    private List<Producto> productos = new ArrayList<Producto>();

    private List<Producto> productosEnPedido = new ArrayList<Producto>();
    @FXML
    private Button btnGenerarOrden;
    @FXML
    private Button btnAgregarProductos;
    @FXML
    private Spinner<Integer> cantidadPiezasSpinner;

    int piezas = 0;
    @FXML
    private TableColumn tableViewColumnDescuento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        objProductos = FXCollections.observableArrayList();
        this.tableViewColumnNombreProducto.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tableViewColumnDescripcionProducto.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.tableViewColumnPrecioUnitarioProducto.setCellValueFactory(new PropertyValueFactory("precio"));
        this.tableViewColumnPiezasProducto.setCellValueFactory(new PropertyValueFactory("numeroPiezas"));
        this.tableViewColumnDsiponibilidadProducto.setCellValueFactory(new PropertyValueFactory("estado"));
        this.tableViewColumnDescuento.setCellValueFactory(new PropertyValueFactory("porcentajeDescuento"));
        this.tableViewColumnInfoAdicionalProducto.setCellValueFactory(new PropertyValueFactory("informacionAdicional"));

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        cantidadPiezasSpinner.setValueFactory(valueFactory);
    }

    @FXML
    private void buscarProducto() {
        this.tableViewProductos.getItems().clear();
        String nombreProducto = txtFieldBuscarProducto.getText();
        Producto producto = new Producto();
        productos = producto.obtenerProductosNombre(nombreProducto);
        for (Producto productoEncontrado : productos) {
            this.objProductos.add(productoEncontrado);
            this.tableViewProductos.setItems(objProductos);
        }
    }

    @FXML
    private void AgregarProductoArray() {
        MiExcepcion mensaje = new MiExcepcion();
        mensaje.mensaje();
        int piezas = cantidadPiezasSpinner.getValue();
        Producto producto = this.tableViewProductos.getSelectionModel().getSelectedItem();
        producto.setNumeroPiezas(piezas);
        productosEnPedido.add(producto);
        
    }

    @FXML
    private void switchToVentanaPedido() throws IOException {

        Pedido pedido = new Pedido();
        pedido.setEstado("pendiente");
        pedido.setInformacionAdicional("");
        Date date = new Date();
        pedido.setFechaHoraPedido(date);
        System.out.println("pedido = " + pedido);

        pedido.guardarPedido(pedido);

        Pedido pedidoEncontrado;
        pedidoEncontrado = pedido.buscarPedidoXEstado();
        System.out.println("pedido encontrado: = " + pedidoEncontrado);
        double subtotalPagarPedido = 0;
        double totalPagarPedido = 0;
        for (Producto producto : productosEnPedido) {
            PedidoProducto pedidoProducto = new PedidoProducto();
            pedidoProducto.setPedido(pedidoEncontrado);
            pedidoProducto.setProducto(producto);
            pedidoProducto.setNumeroPiezas(producto.getNumeroPiezas());
            subtotalPagarPedido = (producto.getPrecio() * producto.getNumeroPiezas());
            pedidoProducto.setSubtotalPagar(subtotalPagarPedido);
            System.out.println("pedidoProducto = " + pedidoProducto);
            totalPagarPedido = totalPagarPedido + subtotalPagarPedido;
            System.out.println("pedidoProducto = " + pedidoProducto);
            pedidoProducto.agregarPedidoProductos(pedidoProducto);
        }
        pedidoEncontrado.setTotalPagar(totalPagarPedido);
        System.out.println("pedidoEncontrado = " + pedidoEncontrado);
        System.out.println("pedido despues de los pedidosProductos = " + pedidoEncontrado);
        App.setRoot("VentanaPedido");
    }

    @FXML
    private void switchToVentanaAgregarProducto() throws IOException {
        App.setRoot("VentanaAgregarProducto");
    }
}
