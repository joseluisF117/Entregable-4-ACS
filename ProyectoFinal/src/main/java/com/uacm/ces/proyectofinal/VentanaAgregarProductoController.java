/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.uacm.ces.proyectofinal;

import com.uacm.ces.proyectofinal.modelo.Producto;
import com.uacm.ces.proyectofinal.modelo.Vendedor;
import com.uacm.ces.proyectofinal.modelo.excepciones.MiExcepcion;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author the_m
 */
public class VentanaAgregarProductoController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextArea textAreaNombre;
    @FXML
    private TextField textFieldNumPiezas;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField textFieldPrecio;
    @FXML
    private TextField textFieldEstado;
    @FXML
    private TextArea textAreanInfoAdicional;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void switchToVentataVentaProducto() throws IOException {
        App.setRoot("VentanaVentaProducto");
    }

    @FXML
    private void guardarProducto() throws MiExcepcion {
        MiExcepcion miExcepcion = new MiExcepcion();
        try {
            String nombre = textFieldNombre.getText();
            String descripcion = textAreaNombre.getText();
            Double precio = Double.parseDouble(textFieldPrecio.getText());
            int numeroPiezas = Integer.parseInt(textFieldNumPiezas.getText());
            String estado = textFieldEstado.getText();
            String infoAdicional = textAreanInfoAdicional.getText();
            miExcepcion.validaTxtVacio(nombre);
            miExcepcion.validaTxtVacio(descripcion);
            miExcepcion.validaTxtVacio(estado);
            miExcepcion.validaTxtVacio(infoAdicional);
            miExcepcion.validaNumeroMinimo(precio);
            miExcepcion.validaNumeroMinimo(numeroPiezas);
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setNumeroPiezas(numeroPiezas);
            producto.setEstado(estado);
            producto.setInformacionAdicional(infoAdicional);
            Vendedor vendedor = new Vendedor();
            producto.setVendedor(vendedor);
            if (validarCamposVacios() && validarMinimo()) {
                producto.agregarProducto(producto);
            }

        } catch (NumberFormatException e) {
            miExcepcion.validaQueEsNum();
        } catch (NullPointerException e) {

            guardarProducto();
        }
    }

    private Boolean validarCamposVacios() {
        Boolean resultado;
        if (textFieldNombre.getText().isEmpty() || textAreaNombre.getText().isEmpty() || textFieldNumPiezas.getText().isEmpty()
                || textFieldPrecio.getText().isEmpty() || textFieldEstado.getText().isEmpty() || textAreanInfoAdicional.getText().isEmpty()) {
            resultado = false;
        } else {
            resultado = true;
        }
        return resultado;
    }

    private Boolean validarMinimo() {
        Boolean resultado;
        if (Integer.parseInt(textFieldNumPiezas.getText()) > 0 && Integer.parseInt(textFieldPrecio.getText()) > 0) {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }
}
