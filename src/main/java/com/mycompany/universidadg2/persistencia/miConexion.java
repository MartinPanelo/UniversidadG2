package com.mycompany.universidadg2.persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Connection;

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
            }catch(ClassNotFoundException ex){
                Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    
}
