/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author jesfree
 */
public class Archivo {
    private final String rutaArchivo;
    private final  String directorio = "data";
    
    
    public  Archivo(String nombreArchivo){
        URL recurso = this.getClass().getResource("/" + directorio + "/" + nombreArchivo);
        rutaArchivo = recurso.getPath();
        System.out.println(rutaArchivo);
    }
    
    
    
    public String leerArchivo() throws FileNotFoundException, IOException{
        String cadena;
        String texto = "";
        FileReader f = new FileReader(rutaArchivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine()) != null){
             //System.out.println(cadena);
             
             texto+=cadena;
             texto+="\n";
        }
            b.close();
            return texto;
    }
    
    
}



