/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uacm.ces.proyectofinal.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author the_m
 */
public class Conexion {

    Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost/farmaceutica";
    private static final String USUARIO = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection obtenerConecxion() {
        System.out.println("Conectando a la base de datos...");
        try { // Se carga el driver JDBC-ODBC
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver JDBC");
        }
        try { // Se establece la conexión con la base de datos
            conn = DriverManager.getConnection(URL + "?" + "user=" + USUARIO);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {

            System.out.println("No se pudo establecer la conexión con la base de datos.");
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
