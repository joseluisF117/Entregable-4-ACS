/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal;

import com.uacm.ces.proyectofinal.persistencia.Archivo;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author jesfree
 */
public class AcercadeController {

    @FXML
    private AnchorPane botonCerrar;
    @FXML
    private TextArea areaDeTextoAcercade;
    
    
    
    
    public void initialize(){
        Archivo objetoArchivo = new Archivo("acercade.txt");
        try{
            areaDeTextoAcercade.appendText(objetoArchivo.leerArchivo());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    


    @FXML
    private void cerrar(ActionEvent event) {
        Node fuente = (Node) event.getSource();
        Stage escenerio = (Stage) fuente.getScene().getWindow();
        escenerio.close();
    }
    
}
