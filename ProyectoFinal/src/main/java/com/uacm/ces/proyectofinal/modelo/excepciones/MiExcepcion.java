package com.uacm.ces.proyectofinal.modelo.excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class MiExcepcion extends Exception {

    public MiExcepcion() {
    }

    public MiExcepcion(String mensajeError) {
        super(mensajeError);
    }

    public void validaQueEsNum() throws MiExcepcion {

        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setTitle("El campo debe ser un numero");
        mensaje.setContentText("Ocurrio un error");
        Label label = new Label("El error es el siguiente");
        TextArea textArea = new TextArea("Debe ser un numero el campo precio y numero de piezas");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        mensaje.getDialogPane().setExpandableContent(label);
        mensaje.getDialogPane().setExpandableContent(textArea);
        mensaje.showAndWait();
    }

    public void validaNumeroMinimo(double numero) throws MiExcepcion {
        if (numero <= 0) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("El valor es invalido para precio");
            mensaje.setContentText("Ocurrio un error");
            Label label = new Label("El error es el siguiente");
            TextArea textArea = new TextArea("El valor debe ser mayor que cero");
            textArea.setEditable(false);
            textArea.setWrapText(true);
            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);
            mensaje.getDialogPane().setExpandableContent(label);
            mensaje.getDialogPane().setExpandableContent(textArea);
            mensaje.showAndWait();
        }
    }

    public static void minimo(int numero) throws MiExcepcion {
        if (numero <= 0) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("El valor es invalido para piezas");
            mensaje.setContentText("Ocurrio un error");
            Label label = new Label("El error es el siguiente");
            TextArea textArea = new TextArea("El valor debe ser mayor que cero");
            textArea.setEditable(false);
            textArea.setWrapText(true);
            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);
            mensaje.getDialogPane().setExpandableContent(label);
            mensaje.getDialogPane().setExpandableContent(textArea);
            mensaje.showAndWait();

        }
    }

    public void validaTxtVacio(String txt) throws MiExcepcion {
        if (txt.contentEquals("")) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("El campo no debe ser vacio");
            mensaje.setContentText("Ocurrio un error");
            Label label = new Label("El error es el siguiente");
            TextArea textArea = new TextArea("Se debe llenar el campo");
            textArea.setEditable(false);
            textArea.setWrapText(true);
            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);
            mensaje.getDialogPane().setExpandableContent(label);
            mensaje.getDialogPane().setExpandableContent(textArea);
            mensaje.showAndWait();
        }
    }

    public void mensaje() {

        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
        mensaje.setTitle("Producto agregado");
        mensaje.setContentText("Se agrego el producto");
        //Label label = new Label("El error es el siguiente");
        /*TextArea textArea = new TextArea("El valor debe ser mayor que cero");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        mensaje.getDialogPane().setExpandableContent(label);
        mensaje.getDialogPane().setExpandableContent(textArea);*/
        mensaje.showAndWait();

    }
}
