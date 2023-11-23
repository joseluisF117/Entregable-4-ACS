/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.uacm.ces.proyectofinal;

import com.uacm.ces.proyectofinal.modelo.Producto;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author the_m
 */
public class VentanaModificarProductoController implements Initializable {
    @FXML
    private Button btnRegresar;
    @FXML
    private TextArea txtAreaDescripcion;
    @FXML
    private ComboBox<String> comboBoxCategoria;
    @FXML
    private DatePicker datePickerFechaCaducidad;
    @FXML
    private Button btnBuscarProducto;
    @FXML
    private Button btnModificarProducto;
    @FXML
    private TextField textFieldBuscarId;
    @FXML
    private TextField txtFieldNombre;
    @FXML
    private TextField txtFieldNumeroPiezas;
    @FXML
    private CheckBox checkBoxExistenciaInventario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxCategoria.getItems().addAll("Abarrotes", "Electronica", "Linea Blanca", "panaderia", "Lacteos");
    }
    @FXML
    private void switchToVentaAlmacenista() throws IOException {
        App.setRoot("VentanaAlmacenista");
    }
    @FXML
    private void buscarProducto() throws IOException {
        int id = Integer.parseInt(textFieldBuscarId.getText());
        Producto producto = new Producto();
        Producto productoEncontrado;
        productoEncontrado = producto.buscarProducto(id);
        System.out.println("productoEncontrado = " + productoEncontrado);
        txtFieldNombre.setText(productoEncontrado.getNombre());
        txtFieldNumeroPiezas.setText(String.valueOf(productoEncontrado.getNumeroPiezas()));
        txtAreaDescripcion.setText(productoEncontrado.getDescripcion());
        txtFieldNumeroPiezas.setText(String.valueOf(productoEncontrado.getNumeroPiezas()));
    }

    @FXML
    private void modificarProducto() throws IOException {
        /*int id = Integer.parseInt(textFieldBuscarId.getText());
        String nombre = txtFieldNombre.getText();
        String descripcion = txtAreaDescripcion.getText();
        int numeroPiezas = Integer.parseInt(txtFieldNumeroPiezas.getText());

        Date fechaCaducidad = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaCaducidad = sdf.parse(datePickerFechaCaducidad.getValue().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int estatusExistencia = 0;
        int categoria = comboBoxCategoria.getSelectionModel().getSelectedIndex();
        if(checkBoxExistenciaInventario.isSelected())
            estatusExistencia = 1;
        Producto producto = new Producto();
        producto.setIdProducto(id);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setFechaCaducidad(fechaCaducidad);
        producto.setEstatusExistencia(estatusExistencia);
        producto.setCategoria(categoria);
        producto.setNumeroPiezas(numeroPiezas);
        System.out.println("estatusExistencia = " + estatusExistencia);
        
        Almacenista almacenista = new Almacenista();
        almacenista.modificarProductoAlmacen(producto);
    }*/

}}
