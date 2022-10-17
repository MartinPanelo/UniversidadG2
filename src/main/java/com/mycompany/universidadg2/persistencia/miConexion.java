/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universidadg2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ezequ
 */
public class miConexion {
    private String url;
    private String usuario;
    private String password;
    private Connection conexion;
    
    public miConexion(String url, String usr, String pass)  {
    this.url = url;
    usuario= usr;
    password = pass;
    }
    public Connection buscarConexion() {
        if (conexion==null) { // si es la primera vez
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                    conexion = DriverManager.getConnection(url, usuario, password);
            } catch (SQLException | ClassNotFoundException ex)  {
                Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion; // retorna la conexion establecida
    }
    
}
