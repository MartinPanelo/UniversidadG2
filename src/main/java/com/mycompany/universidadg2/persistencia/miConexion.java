package com.mycompany.universidadg2.persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class miConexion {
    
    private String url;
    private String usuario;
    private String password;
    private Connection conexion;

    public miConexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }
    
    public Connection buscarConexion(){
        if(conexion==null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("Connected database successfully...");

            }catch(SQLException | ClassNotFoundException ex){
                System.out.println("Error al cargar el driver de mariaDB");
                Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    
}
